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
