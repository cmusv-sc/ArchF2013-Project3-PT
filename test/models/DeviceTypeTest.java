/*
 * Copyright (c) 2013 Carnegie Mellon University Silicon Valley.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available
 * under the terms of dual licensing(GPL V2 for Research/Education
 * purposes). GNU Public License v2.0 which accompanies this distribution
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact http://www.cmu.edu/silicon-valley/ if you have any
 * questions.
 */

package models;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for DeviceType class
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class DeviceTypeTest
{
   private static DeviceType devType;
   private static String TEST_DEVICETYPE = "testDeviceType";
   private static String TEST_TEMP = "Temp";
   private static String TEST_CO2 = "CO2";
   
   /**
    * Setup a DeviceType object to test on
    */
   @BeforeClass
   public static void initDeviceType()
   {
      devType = new DeviceType(TEST_DEVICETYPE);
      devType.add(new SensorType(TEST_TEMP));
      devType.add(new SensorType(TEST_CO2));
   }
   
   /**
    * Simple test of getType in DeviceType
    */
   @Test
   public void getTypeTest()
   {
      String outType = devType.getType();

      assertEquals(TEST_DEVICETYPE, outType);
   }
   
   /**
    * Simple test of getSensorTypes in DeviceType
    */
   @Test
   public void getSensorTypesTest()
   {
      List<SensorType> outList = devType.getSensorTypes();
      String arrStr = outList.toString();
      
      assertTrue(arrStr.contains(TEST_TEMP));
      assertTrue(arrStr.contains(TEST_CO2));
   }
   
   /**
    * Test of Comparable for DeviceType
    */
   @Test
   public void ComparableTest()
   {
      DeviceType compDevType = new DeviceType(TEST_DEVICETYPE);

      int compInt = devType.compareTo(compDevType);
      
      assertEquals(0, compInt);
   }
}
