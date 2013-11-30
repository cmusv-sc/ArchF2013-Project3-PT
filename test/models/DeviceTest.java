package models;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for Device class
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class DeviceTest
{
   private static Device device;
   private static String TEST_DEVICEID = "testDeviceID";
   private static String TEST_DEVICETYPE = "testDeviceType";
   private static String TEST_DEVICEAGENT = "testDeviceAgent";
   private static String TEST_DEVICELOCATION = "testDeviceLocation";
   
   /**
    * Setup a device object to test on
    */
   @BeforeClass
   public static void initDevice()
   {
      DeviceType devType = new DeviceType(TEST_DEVICETYPE);
      device = new Device(TEST_DEVICEID, devType, TEST_DEVICEAGENT, TEST_DEVICELOCATION);
   }
   
   /**
    * Simple test of getters in Device
    * since it is a very simple object
    */
   @Test
   public void getterTest()
   {
      String outDeviceId = device.getDeviceId();
      String outDeviceAgent = device.getDeviceAgent();
      String outDeviceLocation = device.getDeviceLocation();
      String outDeviceType = device.getDeviceType().getType();
      
      assertEquals(TEST_DEVICEID, outDeviceId);
      assertEquals(TEST_DEVICETYPE, outDeviceType);
      assertEquals(TEST_DEVICEAGENT, outDeviceAgent);
      assertEquals(TEST_DEVICELOCATION, outDeviceLocation);
   }
}
