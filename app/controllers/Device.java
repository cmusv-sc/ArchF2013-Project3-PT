package controllers;

public class Device
{
   private final String deviceId;
   private final DeviceType deviceType;
   private final String deviceAgent;
   private final String deviceLocation;

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
