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

/**
 * Pure-Java (POJO) Representation of a Sensor
 * Isolates the business logic of the app from potential changes in the
 * data-access (DAO) layer.
 * 
 * A Sensor is currently expected to reference a DeviceType
 * as well as a SensorType.
 * @author Team Mercury
 */
public class Sensor implements ISensor
{
   /**
    * Default constructor
    */
   public Sensor()
   {
   };

   /**
    * Construct a sensor from a deviceType and sensorType
    * @param deviceType
    * @param sensorType
    */
   public Sensor(String deviceType, String sensorType)
   {
      this.deviceType = deviceType;
      this.sensorType = sensorType;
   }

   public String getDeviceType()
   {
      return deviceType;
   }
 
   public String getSensorType()
   {
      return sensorType;
   }

   @Override
   public String toString()
   {
      return "Sensor [deviceType=" + deviceType + ", sensorType=" + sensorType
            + ", getDeviceType()=" + getDeviceType() + ", getSensorType()="
            + getSensorType() + "]";
   }

   /** the deviceType that contains this sensor */
   private String deviceType;
   /** the sensorType of this sensor */
   private String sensorType;
}
