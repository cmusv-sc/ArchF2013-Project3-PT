package models;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for SensorReading class
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class SensorReadingTest
{
   private static SensorReading reading;
   private static String TEST_DEVICEID = "testDeviceID";
   private static String TEST_SENSORTYPE = "testSensorType";
   private static String TEST_VALUE = "testValue";
   private static String TEST_TIMESTAMP = "testTimestamp";
   
   /**
    * Setup a SensorReading object to test on
    */
   @BeforeClass
   public static void initSensor()
   {
      reading = new SensorReading(TEST_DEVICEID, TEST_SENSORTYPE, TEST_VALUE, TEST_TIMESTAMP);
   }
   
   /**
    * Simple test of getters in SensorReading
    * since it is a very simple object
    */
   @Test
   public void getterTest()
   {
      String outDeviceId = reading.getDeviceId();
      String outSensorType = reading.getSensorType();
      String outValue = reading.getValue();
      String outTimestamp = reading.getTimestamp();
      
      assertEquals(TEST_DEVICEID, outDeviceId);
      assertEquals(TEST_SENSORTYPE, outSensorType);
      assertEquals(TEST_VALUE, outValue);
      assertEquals(TEST_TIMESTAMP, outTimestamp);
   }
}
