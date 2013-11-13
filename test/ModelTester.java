import java.lang.*;
import java.io.*;

import controllers.*;

public class ModelTester {

	public static void main(String[] args) {
		/*
		 * testing setters and getters for Sensor
		 */
		Sensor sensor = new Sensor();
		sensor.setDeviceType("abc");
		sensor.setSensorType("some device Type");
		System.out.printf("sensor data 1:\n %s\n", sensor.toString());
		
		/*
		 * testing constructor for Sensor
		 * 
		 */
		Sensor sensor2 = new Sensor("some device type", "some sensor type");
		System.out.printf("sensor data 2:\n %s\n", sensor2.toString());	
		
		
		/*
		 * testing setters and getters for device
		 */
		
		Device device = new Device();
		device.setDeviceId("some device id");
		device.setDeviceType("some device type");
		device.setDeviceAgent("some device agent");
		device.setDeviceLocation("some device location");
		System.out.printf("device data 1:\n %s\n", device.toString());
		
		
		/*
		 * testing constructor for Device
		 * 
		 */
		
		Device device2 = new Device("second device id", "second device type", 
									"second device agent", "second evice location" );
		
		System.out.printf("device data 2:\n%s\n", device2.toString());
		
		
		/*
		 * testing setters and getters for SensorReading
		 */
		
		SensorReading reading = new SensorReading();
		reading.setDeviceId("read device id 1");
		reading.setSensorType("reading sonsor type 1");
		reading.setTimestamp("1222222");
		reading.setValue("100deg");
		System.out.printf("sensor reading 1:\b %s\n", reading.toString());
		
		/*
		 * testing constructor for SensorReading
		 */
		SensorReading reading2 = new SensorReading("device id 2", "sensor type 2", "666", "8888888");
		System.out.printf("sensor reading 2:\n %s\n", reading2.toString());
	}

}
