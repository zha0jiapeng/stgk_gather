package com.stgk.gather.scheduled;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.serial.SerialPortWrapper;
import com.stgk.gather.entity.Transformer;
import com.stgk.gather.entity.TransformerMonitor;
import com.stgk.gather.service.ITransformerMonitorService;
import com.stgk.gather.service.ITransformerService;
import com.stgk.gather.utils.ModBusUtils;
import com.stgk.gather.utils.SerialPortWrapperImpl;
import jssc.SerialPort;
import jssc.SerialPortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class TransformerScheduled {

    //串行波特率
    private final static int BAUD_RATE = 9600;

    //串口号
    @Value("${server.serialPort:COM6}")
    public String SERIALPORT = null;

    @Autowired
    private ITransformerService transformerService;

    @Autowired
    private ITransformerMonitorService transformerMonitorService;
    /**
     * 电缆相关数据
     * 1.温度 目前模拟传感器之间500m 0-199为温度 200-399为电流值
     * 2.电流 同一时刻电流值恒定 取一个就可
     */
    @Scheduled(cron ="0 0/1 * * * ?")
    private void transformer() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        System.out.println("变压器信息入库：" + now);
        System.out.println("变压器信息入库：" + SERIALPORT);
        SerialPortWrapper serialParameters = new
                SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
        /* 创建ModbusFactory工厂实例 */
        ModbusFactory modbusFactory = new ModbusFactory();
        /* 创建ModbusMaster实例 */
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
        master.setTimeout(10000);
        try {
            master.init();
            List<Transformer> transformerList = transformerService.list();
            for (Transformer transformer : transformerList) {
                System.out.println("变压器信息入库SlaveId：" + transformer.getSlaveId());
                //变压器温度数据 400-500
                short[] shorts = readHoldingRegistersTest(master, transformer.getSlaveId(), 400, 80);
                TransformerMonitor transformerMonitor = new TransformerMonitor();
                transformerMonitor.setTransformerId(transformer.getId());
                transformerMonitor.setMonitorTime(now);
                transformerMonitor.setaBurnerTemperature(new BigDecimal(shorts[0]));
                transformerMonitor.setaOutletTemperature(new BigDecimal(shorts[1]));
                transformerMonitor.setbBurnerTemperature(new BigDecimal(shorts[2]));
                transformerMonitor.setbOutletTemperature(new BigDecimal(shorts[3]));
                transformerMonitor.setcBurnerTemperature(new BigDecimal(shorts[4]));
                transformerMonitor.setcOutletTemperature(new BigDecimal(shorts[5]));
                transformerMonitor.setCoreTemperature(new BigDecimal(shorts[6]));
                transformerMonitor.setAmbientTemperature(new BigDecimal(shorts[7]));

                //变压器电压数据 500-600
                short[] shorts1 = readHoldingRegistersTest(master, 128, 500, 10);
                transformerMonitor.setTransformerVoltage(new BigDecimal(shorts1[0]));
                //变压器电流数据 600-700
                short[] shorts2 = readHoldingRegistersTest(master, 128, 600, 10);
                transformerMonitor.setTransformerACurrent(new BigDecimal(shorts2[0]));
                transformerMonitor.setTransformerBCurrent(new BigDecimal(shorts2[1]));
                transformerMonitor.setTransformerCCurrent(new BigDecimal(shorts2[2]));
                transformerMonitor.setTransformerPower(new BigDecimal(0.95));
                //模拟红外温度
                transformerMonitor.setRedTemperature(new BigDecimal(32));
                transformerMonitorService.save(transformerMonitor);
                //带载运行时间 监测到变压器有三相电流开始时间到现在 每一分钟一监测
                //每分钟监测时候 有电流 就认为是带载工作了一分钟
                if(transformerMonitor.getTransformerACurrent().compareTo(BigDecimal.ZERO)!=0&&
                        transformerMonitor.getTransformerBCurrent().compareTo(BigDecimal.ZERO)!=0&&
                        transformerMonitor.getTransformerCCurrent().compareTo(BigDecimal.ZERO)!=0
                ){
                    transformer.setOnloadRuntime(transformer.getOnloadRuntime()+1);
                }else{
                    //空载就是带电到不带电的时间
                    //每分钟监测时候 无电流 就认为是空载工作了一分钟
                    transformer.setOffloadRuntime(transformer.getOffloadRuntime()+1);
                }
    //            //退出时间 不带电的开是时间到当前
    //            if(transformerMonitor.getTransformerCurrent()==null ||
    //                    transformerMonitor.getTransformerCurrent().compareTo(BigDecimal.ZERO)==0){
    //                transformer.setExitRuntime(transformer.getExitRuntime()+1);
    //            }
                BigDecimal avg= (transformerMonitor.getTransformerACurrent()
                                    .add(transformerMonitor.getTransformerBCurrent())
                                    .add(transformerMonitor.getTransformerCCurrent())).divide(new BigDecimal(3),2,BigDecimal.ROUND_HALF_UP);
                if(avg.compareTo(transformer.getRatedCurrent())>0){
                    transformer.setOverloadNum(transformer.getOverloadNum()+1);
                    transformer.setOverloadTime(transformer.getOverloadTime()+1);
                }
                transformerService.update(transformer,new LambdaUpdateWrapper<Transformer>().eq(Transformer::getId,transformer.getId()));
            }
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } finally {
            master.destroy();
        }
    }

    private static  short[] readHoldingRegistersTest(ModbusMaster master, int slaveId, int start, int len) {
        System.out.println(start+":"+len);
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse)master.send(request);
            if (response.isException()) {
                System.out.println("Exception response: message=" + response.getExceptionMessage());
            } else {
                System.out.println(Arrays.toString(response.getShortData()));
                short[] list = response.getShortData();
                return list;
            }
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        }
        return null;
    }

}
