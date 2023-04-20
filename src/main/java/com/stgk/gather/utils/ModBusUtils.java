package com.stgk.gather.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.serotonin.modbus4j.Modbus;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.msg.ReadResponse;
import com.serotonin.modbus4j.serial.SerialPortWrapper;

/**
 * 通过串口解析MODBUS协议
 * @author yaohj
 */
public class ModBusUtils {
    // 设定MODBUS网络上从站地址
    private final static int SLAVE_ADDRESS = 128;
    //串行波特率
    private final static int BAUD_RATE = 9600;

    public static ModbusMaster initConnect () {
        SerialPortWrapper serialParameters = new
                SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
        /* 创建ModbusFactory工厂实例 */
        ModbusFactory modbusFactory = new ModbusFactory();
        /* 创建ModbusMaster实例 */
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
        master.setTimeout(10000);
        try {
            master.init();
            return master;
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } finally {
            master.destroy();
        }
        return null;
    }

    public static void main(String[] args) {
            SerialPortWrapper serialParameters = new
                    SerialPortWrapperImpl("COM6", BAUD_RATE, 8, 1, 0, 0, 0);
            /* 创建ModbusFactory工厂实例 */
            ModbusFactory modbusFactory = new ModbusFactory();
            /* 创建ModbusMaster实例 */
            ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
            master.setTimeout(5000);
        /* 初始化 */
        try {
            master.init();
            readHoldingRegistersTest(master, SLAVE_ADDRESS, 100, 100);
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } finally {
            master.destroy();
        }
    }

    /**
     * 读保持寄存器上的内容
     * @param master 主站
     * @param slaveId 从站地址
     * @param start 起始地址的偏移量
     * @param len 待读寄存器的个数
     */
    private static void readHoldingRegistersTest(ModbusMaster master, int slaveId, int start, int len) {
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse)master.send(request);
            if (response.isException()) {
                System.out.println("Exception response: message=" + response.getExceptionMessage());
                readHoldingRegistersTest(master,slaveId,start,len);
            } else {
                System.out.println(Arrays.toString(response.getShortData()));
                short[] list = response.getShortData();
                for (int i = 0; i < list.length; i++) {
                    System.out.print(list[i] + " ");
                }
            }
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        }
    }
}

