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
