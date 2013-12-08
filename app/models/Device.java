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

import models.DeviceType;

/**
 * Pure-Java (POJO) Representation of a Device
 * Isolates the business logic of the app from potential changes in the
 * data-access (DAO) layer.
 * 
 * Device is expected to contain a unique ID, a type,
 * an agent, and a location
 * @author Team Mercury
 */
public class Device implements IDevice
{
   private final String deviceId;
   private final DeviceType deviceType;
   private final String deviceAgent;
   private final String deviceLocation;

   /**
    * Device constructor - takes all the info a Device requires
    * @param deviceId
    * @param deviceType
    * @param deviceAgent
    * @param deviceLocation
    */
   public Device(String deviceId, 
                 DeviceType deviceType, 
                 String deviceAgent,
                 String deviceLocation)
   {
      this.deviceId = deviceId;
      this.deviceType = deviceType;
      this.deviceAgent = deviceAgent;
      this.deviceLocation = deviceLocation;
   }

   public String getDeviceId()
   {
      return deviceId;
   }

   public DeviceType getDeviceType()
   {
      if (deviceType == null) {
        return new DeviceType("none");
      }
      return deviceType;
   }

   public String getDeviceAgent()
   {
      return deviceAgent;
   }

   public String getDeviceLocation()
   {
      return deviceLocation;
   }

   @Override
   public String toString()
   {
      return "Device [deviceId=" + deviceId + ", deviceType=" + deviceType
            + ", deviceAgent=" + deviceAgent + ", deviceLocation="
            + deviceLocation + ", getDeviceId()=" + getDeviceId()
            + ", getDeviceType()=" + getDeviceType() + ", getDeviceAgent()="
            + getDeviceAgent() + ", getDeviceLocation()=" + getDeviceLocation()
            + "]";
   }
}
