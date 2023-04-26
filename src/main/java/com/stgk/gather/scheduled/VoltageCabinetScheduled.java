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
import com.stgk.gather.entity.VoltageCabinet;
import com.stgk.gather.entity.VoltageCabinetMonitor;
import com.stgk.gather.service.ITransformerMonitorService;
import com.stgk.gather.service.ITransformerService;
import com.stgk.gather.service.IVoltageCabinetMonitorService;
import com.stgk.gather.service.IVoltageCabinetService;
import com.stgk.gather.utils.SerialPortWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class VoltageCabinetScheduled {

    //串行波特率
    private final static int BAUD_RATE = 9600;

    //串口号
    @Value("${server.serialPort:COM6}")
    public String SERIALPORT = null;
    @Autowired
    private IVoltageCabinetService voltageCabinetService;


    @Autowired
    private IVoltageCabinetMonitorService voltageCabinetMonitorService;
    /**
     * 电缆相关数据
     * 1.温度 目前模拟传感器之间500m 0-199为温度 200-399为电流值
     * 2.电流 同一时刻电流值恒定 取一个就可
     */
    @Scheduled(cron ="0 0/1 * * * ?")
    private void transformer() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        System.out.println("高压柜信息入库：" + now);
        System.out.println("高压柜信息入库：" + SERIALPORT);
        SerialPortWrapper serialParameters = new
                SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
        /* 创建ModbusFactory工厂实例 */
        ModbusFactory modbusFactory = new ModbusFactory();
        /* 创建ModbusMaster实例 */
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
        master.setTimeout(10000);
        try {
            master.init();
            List<VoltageCabinet> voltageCabinetList = voltageCabinetService.list();
            for (VoltageCabinet voltageCabinet : voltageCabinetList) {
                short[] shorts = readHoldingRegistersTest(master, 128 , 0, 80);
                VoltageCabinetMonitor voltageCabinetMonitor = new VoltageCabinetMonitor();
                voltageCabinetMonitor.setMonitorTime(now);
                voltageCabinetMonitor.setCabinetId(voltageCabinet.getId());
                voltageCabinetMonitor.setaCurrent(new BigDecimal(shorts[0]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setbCurrent(new BigDecimal(shorts[1]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setcCurrent(new BigDecimal(shorts[2]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setUabVoltage(new BigDecimal(shorts[3]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setpPower(new BigDecimal(shorts[4]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setCos(new BigDecimal(shorts[5]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setRh(new BigDecimal(shorts[6]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setPd(new BigDecimal(shorts[7]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerUpATemperature(new BigDecimal(shorts[8]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerUpBTemperature(new BigDecimal(shorts[9]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerUpCTemperature(new BigDecimal(shorts[10]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerDownATemperature(new BigDecimal(shorts[11]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerDownBTemperature(new BigDecimal(shorts[12]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerDownCTemperature(new BigDecimal(shorts[13]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerOutATemperature(new BigDecimal(shorts[14]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerOutBTemperature(new BigDecimal(shorts[15]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setBreakerOutCTemperature(new BigDecimal(shorts[16]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setClosingCoilCurrent(new BigDecimal(shorts[17]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setOpeningCoilCurrent(new BigDecimal(shorts[18]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setStorageMotorCurrent(new BigDecimal(shorts[19]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setDisplacement(new BigDecimal(shorts[20]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitor.setTrip(new BigDecimal(shorts[21]).divide(new BigDecimal(10),RoundingMode.HALF_UP));
                voltageCabinetMonitorService.save(voltageCabinetMonitor);
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
