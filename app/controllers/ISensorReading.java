/**
 * 
 */
package controllers;

/**
 * @author danny brown
 * 
 * @responsibilities interface for the encapsulation of
 *                   a single sensor reading returned from platform
 *                   API calls
 */
public interface ISensorReading {
	/*
	 * Returns the device id for the sensor reading
	 * 
	 * @return the device id as string
	 */
	public String getDeviceId();
	/*
	 * Returns the sensor type of the sensor reading
	 * 
	 * @return the sensor type as string
	 */
	public String getSensorType();
	/*
	 * Returns the timestamp associated with the reading
	 * 
	 * @return the timestamp for this reading
	 */
	public String getTimestamp();
	/*
	 * Returns the value of the sensor reading
	 * 
	 * @return the value of the reading
	 */
	public String getValue();
	/*
	 * Sets the device id associated with this sensor reading
	 * 
	 * @param deviceId 		A String representation of the device id
     *
	 */
	public void setDeviceId(String id);
	/*
	 * Sets the sensor type associated with this sensor reading
	 * 
	 * @param sensorType		A String representation of the sensor type
	 * 
	 */	
	public void setSensorType(String sensorType);
	/*
	 * Sets the value of this sensor reading
	 * 
	 * @param value 	A String representation of the value of the reading
	 * 
	 */	
	public void setValue(String value);	
	/*
	 * Sets the timestamp associated with this sensor reading
	 * 
	 * @param timestamp	A String representation of the timestamp of the reading
	 * 
	 */		
	public void setTimestamp(String timestamp);

}
