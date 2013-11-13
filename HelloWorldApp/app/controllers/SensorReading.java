package controllers;

public class SensorReading implements ISensorReading{
	public SensorReading(){};
	public SensorReading(String deviceId,
	  					 String sensorType,
	  					 String value,
	  					 String timestamp) 
	{
		this.deviceId 	= deviceId;
		this.sensorType = sensorType;
		this.value 		= value;
		this.timestamp  = timestamp;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
	@Override
	public String toString() {
		return "SensorReading [deviceId=" + deviceId + ", sensorType="
				+ sensorType + ", value=" + value + ", timestamp=" + timestamp
				+ ", getDeviceId()=" + getDeviceId() + ", getSensorType()="
				+ getSensorType() + ", getValue()=" + getValue()
				+ ", getTimestamp()=" + getTimestamp() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	String deviceId;
	String sensorType;
	String value;
	String timestamp;

}
