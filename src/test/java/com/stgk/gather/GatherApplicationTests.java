package com.stgk.gather;




import com.stgk.gather.entity.CableIndexMonitor;
import com.stgk.gather.service.ICableIndexMonitorService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jssc.SerialPort;
import jssc.SerialPortException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
class GatherApplicationTests {

	@Autowired
	private ICableIndexMonitorService cableIndexMonitorService;

	@Test
	void contextLoads() throws ParseException, SerialPortException {
		SerialPort serialPort = new SerialPort("COM6");
		boolean b = serialPort.openPort();
		System.out.println(b);
	}
}