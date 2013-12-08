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

import models.Device;
import models.DeviceType;
import models.SensorType;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Devices page controller
 * 
 * @author Team Mercury
 */
public class Devices extends Controller
{
   /**
    * Helper for getDeviceTypes for populating UI elements
    * @return Result
    */
   public static Result getDeviceTypes()
   {
      List<DeviceType> deviceTypes = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         deviceTypes = deviceManager.getDeviceTypes();
      } catch (Exception e)
      {
          Logger.error(e.getMessage(), e);
          return internalServerError(e.getMessage());
      }
      return ok(views.html.deviceType.dropdown.render(deviceTypes));
   }

   /**
    * Helper for getDeviceTypeList for populating UI elements
    * @return Result
    */
   public static Result getDeviceTypeList()
   {
      List<DeviceType> deviceTypes = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         deviceTypes = deviceManager.getDeviceTypes();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest(e.getMessage());
      }
      return ok(views.html.deviceType.devicetypelist.render(deviceTypes));
   }

   /**
    * Helper for getting SensorTypes based on DeviceType
    * for populating UI elements
    * @param deviceType 
    * @return Result
    */
   public static Result getSensorTypes(String deviceType)
   {
      try
      {
         @SuppressWarnings("unused")
         List<SensorType> sensorTypes = null;
         DeviceManager deviceManager = new DeviceManager();
         sensorTypes = deviceManager.getSensorTypes(deviceType);
         // return ok(views.html.sensorType.dropdown.render(sensorTypes));
         return ok();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest();
      }
   }

   /**
    * Helper for getting sensors for populating UI elements
    * @return Result
    */
   public static Result getSensors()
   {
      List<Device> devices = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         devices = deviceManager.getDevices();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest(e.getMessage());
      }
      return ok(views.html.devices.sensorlist.render(devices));
   }

   /**
    * Helper for getting devices for populating UI elements
    * @return Result
    */
   public static Result getDevices()
   {
      List<Device> devices = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         devices = deviceManager.getDevices();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest(e.getMessage());
      }
      return ok(views.html.devices.devicelist.render(devices));
   }

   /**
    * Helper for getting device agents for populating UI elements
    * @return Result
    */
   public static Result getDeviceAgents()
   {
      List<String> deviceAgents = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         deviceAgents = deviceManager.getDeviceAgents();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest(e.getMessage());
      }
      return ok(views.html.devices.deviceagentlist.render(deviceAgents));
   }

   /**
    * Helper for getting all sensor types for populating UI elements
    * @return Result
    */
   public static Result getAllSensorTypes()
   {
      List<String> sensorTypes = null;
      try
      {
         DeviceManager deviceManager = new DeviceManager();
         sensorTypes = deviceManager.getAllSensorTypes();
      } catch (Exception e)
      {
         e.printStackTrace();
         return badRequest(e.getMessage());
      }
      return ok(views.html.sensorType.sensortypelist.render(sensorTypes));
   }
}
