package models;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for Sensor class
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class SensorTest
{
   private static Sensor sensor;
   private static String TEST_DEVICE = "testDeviceType";
   private static String TEST_SENSORTYPE = "testSensorType";
   
   /**
    * Setup a sensor object to test on
    */
   @BeforeClass
   public static void initSensor()
   {
      sensor = new Sensor(TEST_DEVICE, TEST_SENSORTYPE);
   }
   
   /**
    * Simple test of getters in Sensor
    * since it is a very simple object
    */
   @Test
   public void getterTest()
   {
      String outDevice = sensor.getDeviceType();
      String outSensorType = sensor.getSensorType();
      assertEquals(TEST_DEVICE, outDevice);
      assertEquals(TEST_SENSORTYPE, outSensorType);
   }
}
