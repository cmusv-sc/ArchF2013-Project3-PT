package models;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for SensorType class
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class SensorTypeTest
{
   private static SensorType sType;
   private static String TEST_SENSORTYPE = "testSensorType";
   private static String TEST_TEMP = "Temp";
   private static String TEST_CO2 = "CO2";
   
   /**
    * Setup a DeviceType object to test on
    */
   @BeforeClass
   public static void initSensorType()
   {
      sType = new SensorType(TEST_SENSORTYPE);
   }
   
   /**
    * Simple test of getType in DeviceType
    */
   @Test
   public void getTypeTest()
   {
      String outType = sType.getType();

      assertEquals(TEST_SENSORTYPE, outType);
   }
   
   /**
    * Test of Comparable for SensorType
    */
   @Test
   public void ComparableTest()
   {
      SensorType compSType = new SensorType(TEST_SENSORTYPE);

      int compInt = sType.compareTo(compSType);
      
      assertEquals(0, compInt);
   }
   
   /**
    * Test of parseSensorList for SensorType
    */
   @Test
   public void ParseSensorListTest()
   {
      //make a list to parse
      String testList = TEST_TEMP + "," + TEST_CO2;
      Set<SensorType> testSet = SensorType.parseSensorTypeList(testList);
      SensorType compTemp = new SensorType(TEST_TEMP);
      SensorType compCO2 = new SensorType(TEST_CO2);
      
      assertTrue(testSet.contains(compTemp));
      assertTrue(testSet.contains(compCO2));
   }
}
