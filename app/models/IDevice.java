package models;

/**
 * @author Team Mercury
 * 
 * @responsibilities interface for the encapsulation of a single device object
 *                   returned from platform API calls
 */
public interface IDevice
{
   /**
    * Returns the uri (id) of the device
    * 
    * @return the device id
    */
   public String getDeviceId();

   /**
    * Returns the model of this device
    * 
    * @return the device type
    */
   public DeviceType getDeviceType();

   /**
    * Returns the name of the device agent for this device
    * 
    * @return the name of the agent as a string
    */
   public String getDeviceAgent();

   /**
    * Returns the name of the location of the device
    * 
    * @return the location of the device
    */
   public String getDeviceLocation();
}
