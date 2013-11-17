package controllers;

/**
 * @author danny brown
 * 
 * @responsibilities interface for the encapsulation of
 *                   a sensor object returned from platform
 *                   API calls
 */
public interface ISensor {
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
	/**
	 * Sets the sensor type
	 * 
	 * @param sensorType	A String representation of the sensor type
	 * 
	 */		
	public void setSensorType(String sensorType);
	/**
	 * Sets the name of the device agent device type that contains this sensor
	 * 
	 * @param deviceType	A String representation device type
	 * 
	 */		
	public void setDeviceType(String deviceType);
}
