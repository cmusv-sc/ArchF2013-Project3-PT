/**
 * 
 */
package models;
import java.lang.*;

/**
 * @author danny brown
 * 
 * @responsibilities interface for the encapsulation of a single
 *                   device object returned from platform
 *                   API calls
 */
public interface IDevice {
	/*
	 * Returns the uri (id) of the device
	 * 
	 * @return the device id
	 */		
	public String getDeviceId();
	/*
	 * Returns the model of this device
	 * 
	 * @return the device type as a string
	 */		
	public String getDeviceType();
	/*
	 * Returns the name of the device agent for this device
	 * 
	 * @return the name of the agent as a string
	 */		
	public String getDeviceAgent();
	/*
	 * Returns the name of the location of the device
	 * 
	 * @return the location of the device
	 */		
	public String getDeviceLocation();
	
	/*
	 * Sets the id of the device
	 * 
	 * @param deviceId		A String representation of device id
	 * 
	 */		
	public void setDeviceId(String deviceId);
	/*
	 * Sets the sensor type
	 * 
	 * @param deviceType		A String representation of the device type
	 * 
	 */		
	public void setDeviceType(String deviceType);
	/*
	 * Sets the name of the device agent for this sensor
	 * 
	 * @param agent		A String representing the name of the agent
	 * 
	 */		
	public void setDeviceAgent(String deviceAgent);
	/*
	 * Sets the location of this device
	 * 
	 * @param deviceLocation	A String representing the name of the location
	 * 
	 */		
	public void setDeviceLocation(String deviceLocation);	
}
