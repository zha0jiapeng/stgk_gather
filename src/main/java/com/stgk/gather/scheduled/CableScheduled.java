package com.stgk.gather.scheduled;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.serotonin.modbus4j.Modbus;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.base.ModbusUtils;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.serial.SerialPortWrapper;
import com.stgk.gather.entity.Cable;
import com.stgk.gather.entity.CableIndexMonitor;
import com.stgk.gather.service.ICableIndexMonitorService;
import com.stgk.gather.service.ICableService;
import com.stgk.gather.utils.ModBusUtils;
import com.stgk.gather.utils.SerialPortWrapperImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class CableScheduled {

    @Autowired
    private ICableService cableService;

    @Autowired
    private ICableIndexMonitorService cableIndexMonitorService;

    //串行波特率
    private final static int BAUD_RATE = 9600;

    //串口号
    private final static String COM = "COM6";

    /**
     * 电缆相关数据
     * 1.温度 目前模拟传感器之间500m 0-199为温度 200-399为电流值
     * 2.电流 同一时刻电流值恒定 取一个就可
     */
   //@Scheduled(cron ="0 0/1 * * * ?")
    private void cable() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        System.out.println("电缆信息入库：" + now);
        SerialPortWrapper serialParameters = new
                SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
        /* 创建ModbusFactory工厂实例 */
        ModbusFactory modbusFactory = new ModbusFactory();
        /* 创建ModbusMaster实例 */
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
        master.setTimeout(10000);
        try {
            master.init();
            /* 初始化 */
            List<Cable> cables = cableService.list(new LambdaQueryWrapper<>());
            for (Cable cable : cables) {
                List<CableIndexMonitor> list = new ArrayList();
                //取温度
                getTemperatureLists(now, master, list, cable.getCableSlaveId() , 4);
                //取电流
                short current = getCurrent(now, master, list, cable.getCableSlaveId(), 4);
                list.stream().forEach(e->e.setCableCurrent(new BigDecimal(current)));
                cableIndexMonitorService.saveBatch(list);
                updateCable(cable, list);
            }
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } finally {
            master.destroy();
        }
    }

    private void updateCable(Cable cable, List<CableIndexMonitor> list) {
        BigDecimal max = list.stream().map(CableIndexMonitor::getCableTemperature).max(BigDecimal::compareTo).get();
        BigDecimal min = list.stream().map(CableIndexMonitor::getCableTemperature).min(BigDecimal::compareTo).get();
        BigDecimal avg = list.stream()
                .map(vo -> ObjectUtils.isEmpty(vo.getCableTemperature()) ? new BigDecimal(0) : vo.getCableTemperature())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(list.stream().filter(e-> e.getCableTemperature().compareTo(BigDecimal.ZERO)!=0).count()), 2, BigDecimal.ROUND_HALF_UP);
        Cable update = new Cable();
        if(avg.compareTo(new BigDecimal(cable.getCableEarlyWarning()))<0) {
            update.setCableStatus(0);
        }else if(avg.compareTo(new BigDecimal(cable.getCableEarlyWarning()))>0 && avg.compareTo(new BigDecimal(cable.getCableReportWarning()))<0){
            update.setCableStatus(1);
        }else if(avg.compareTo(new BigDecimal(cable.getCableAlarmWarning()))>0){
            update.setCableStatus(2);
        }else{
            update.setCableStatus(-1);
        }
        update.setCableMaxTemperature(max);
        update.setCableMinTemperature(min);
        update.setCableAvgTemperature(avg);
        cableService.update(update,new LambdaUpdateWrapper<Cable>().eq(Cable::getId,cable.getId()));
    }

    private void getTemperatureLists(LocalDateTime now, ModbusMaster master, List<CableIndexMonitor> list, Integer slaveId ,int count) {
        e:for (int y = 1; y < y+count; y++) {
            short[] shorts = readHoldingRegistersTest(master, slaveId, (y-1)*50, 50);
            for (int i = 0; i < shorts.length; i++) {
                if(shorts[i] ==0){
                    break e;
                }
                CableIndexMonitor cableIndexMonitor = new CableIndexMonitor();
                cableIndexMonitor.setCableId(2);
                cableIndexMonitor.setSensorIndex((y-1)*50+i);
                cableIndexMonitor.setCableTemperature(
                        new BigDecimal(shorts[i])
                                .subtract(new BigDecimal(600))
                                .divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP)
                );
                cableIndexMonitor.setMonitorTime(now);
                list.add(cableIndexMonitor);
            }
        }
    }
    private short getCurrent(LocalDateTime now, ModbusMaster master, List<CableIndexMonitor> list, Integer slaveId ,int count) {
        for (int y = 1; y <= count; y++) {
            short[] shorts = readHoldingRegistersTest(master, slaveId, (y+3)*50, 50);
            for (int i = 0; i < shorts.length; i++) {
                if(shorts[i] ==0){
                    continue;
                }
                return shorts[i];
            }
        }
        return 0;
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
