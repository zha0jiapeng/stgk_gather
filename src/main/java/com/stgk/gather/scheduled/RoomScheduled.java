package com.stgk.gather.scheduled;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.serial.SerialPortWrapper;
import com.stgk.gather.entity.Room;
import com.stgk.gather.entity.RoomMonitor;
import com.stgk.gather.service.IRoomMonitorService;
import com.stgk.gather.service.IRoomService;
import com.stgk.gather.utils.SerialPortWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class RoomScheduled {

    //串行波特率
    private final static int BAUD_RATE = 9600;

    //串口号
    @Value("${server.serialPort:COM6}")
    public String SERIALPORT = null;

    @Autowired
    private IRoomService roomService;


    @Autowired
    private IRoomMonitorService roomMonitorService;

    //配电室数据监控 温湿度
    //@Scheduled(cron ="0 0/1 * * * ?")
    private void transformer() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        System.out.println("配电室信息入库：" + now);
        System.out.println("配电室信息入库：" + SERIALPORT);
        SerialPortWrapper serialParameters = new
                SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
        /* 创建ModbusFactory工厂实例 */
        ModbusFactory modbusFactory = new ModbusFactory();
        /* 创建ModbusMaster实例 */
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
        master.setTimeout(10000);
        try {
            master.init();
            List<Room> roomtList = roomService.list();
            for (Room room : roomtList) {
                short[] datas = readHoldingRegistersTest(master, room.getSlaveId() , 0, 80);
                RoomMonitor roomMonitor = new RoomMonitor();
                roomMonitor.setRoomId(room.getId());
                roomMonitor.setMonitorTime(now);
                roomMonitor.setTemperature((new BigDecimal(datas[9]).subtract(new BigDecimal(600))).divide(new BigDecimal(10),BigDecimal.ROUND_HALF_UP));
                roomMonitor.setHumidity((new BigDecimal(datas[10]).subtract(new BigDecimal(600))).divide(new BigDecimal(10),BigDecimal.ROUND_HALF_UP));
                roomMonitorService.save(roomMonitor);
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
