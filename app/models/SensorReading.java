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
 * Pure-Java (POJO) Representation of a SensorReading
 * Isolates the business logic of the app from potential changes in the
 * data-access (DAO) layer.
 * 
 * A SensorReading is currently expected to contain an id for the device
 * making the reading, the type of sensor being used, the time the reading
 * took place, as well as the value of the reading.
 * 
 * @author Team Mercury
 */
public class SensorReading implements ISensorReading
{
   /**
    * default ctor
    */
   public SensorReading()
   {
   };

   /**
    * Ctor that takes all info that a SensorReading needs
    * @param deviceId
    * @param sensorType
    * @param value
    * @param timestamp
    */
   public SensorReading(String deviceId, String sensorType, 
                        String value, String timestamp)
   {
      this.deviceId = deviceId;
      this.sensorType = sensorType;
      this.value = value;
      this.timestamp = timestamp;
   }

   public String getDeviceId()
   {
      return deviceId;
   }

   public void setDeviceId(String deviceId)
   {
      this.deviceId = deviceId;
   }

   public String getSensorType()
   {
      return sensorType;
   }

   public void setSensorType(String sensorType)
   {
      this.sensorType = sensorType;
   }

   public String getValue()
   {
      return value;
   }

   public void setValue(String value)
   {
      this.value = value;
   }

   public String getTimestamp()
   {
      return timestamp;
   }

   public void setTimestamp(String timestamp)
   {
      this.timestamp = timestamp;
   }

   @Override
   public String toString()
   {
      return "SensorReading [deviceId=" + deviceId + ", sensorType="
            + sensorType + ", value=" + value + ", timestamp=" + timestamp
            + ", getDeviceId()=" + getDeviceId() + ", getSensorType()="
            + getSensorType() + ", getValue()=" + getValue()
            + ", getTimestamp()=" + getTimestamp() + ", getClass()="
            + getClass() + ", hashCode()=" + hashCode() + ", toString()="
            + super.toString() + "]";
   }

   /** deviceId that the reading belongs to */
   String deviceId;
   /** type of sensor the reading is for */
   String sensorType;
   /** value of reading */
   String value;
   /** timestamp of reading */
   String timestamp;

}
