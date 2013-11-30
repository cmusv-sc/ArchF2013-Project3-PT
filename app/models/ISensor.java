package models;

/**
 * @author Team Mercury
 * 
 * @responsibilities interface for the encapsulation of a sensor object returned
 *                   from platform API calls
 */
public interface ISensor
{
   /**
    * Returns the sensor type of the sensor
    * 
    * @return the sensor type as a string
    */
   public String getSensorType();

   /**
    * Returns the name of the device type for the sensor
    * 
    * @return the name of the agent as a string
    */
   public String getDeviceType();
}
