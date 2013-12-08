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
