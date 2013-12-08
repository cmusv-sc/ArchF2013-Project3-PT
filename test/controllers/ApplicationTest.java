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

package controllers;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import play.libs.F.Callback;
import play.test.TestBrowser;

/**
 * Contains unit tests for Application class
 * 
 * Commenting out non-index page tests because they take a long time
 * 
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class ApplicationTest
{
   /**
    * simple test to check if the index page is being shown
    */
   @Test
   public void indexTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333");
                  assertThat(browser.pageSource()).contains(
                        "Team Mercury");
               }
            });
   }
   
   /**
    * simple test to check if the dashboard page is being shown
    */
   //@Test
   public void dashboardTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/dashboard");
                  assertThat(browser.pageSource()).contains(
                        "Sensor Dashboard");
               }
            });
   }
   
   /**
    * simple test to check if the sensors page is being shown
    */
   //@Test
   public void sensorsTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/sensors");
                  assertThat(browser.pageSource()).contains(
                        "Sensors");
               }
            });
   }
   
   /**
    * simple test to check if the devices page is being shown
    */
   //@Test
   public void devicesTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/devices");
                  assertThat(browser.pageSource()).contains(
                        "DeviceList");
               }
            });
   }
   
   /**
    * simple test to check if the device_agents page is being shown
    */
   //@Test
   public void deviceAgentsTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/device_agents");
                  assertThat(browser.pageSource()).contains(
                        "DeviceAgents");
               }
            });
   }
   
   /**
    * simple test to check if the sensor_types page is being shown
    */
   //@Test
   public void sensorTypesTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/sensor_types");
                  assertThat(browser.pageSource()).contains(
                        "SensorTypes");
               }
            });
   }
   
   /**
    * simple test to check if the device_types page is being shown
    */
   //@Test
   public void deviceTypesTest()
   {
      running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
            new Callback<TestBrowser>()
            {
               public void invoke(TestBrowser browser)
               {
                  browser.goTo("http://localhost:3333/device_types");
                  assertThat(browser.pageSource()).contains(
                        "DeviceTypes");
               }
            });
   }
}
