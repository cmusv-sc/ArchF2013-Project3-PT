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
