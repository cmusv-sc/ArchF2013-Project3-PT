package models;

public class Sensor implements ISensor {
	public Sensor(){};
	public Sensor(String deviceType,
				  String sensorType){
		this.deviceType = deviceType;
		this.sensorType = sensorType;
	}

	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	
	@Override
	public String toString() {
		return "Sensor [deviceType=" + deviceType + ", sensorType="
				+ sensorType + ", getDeviceType()=" + getDeviceType()
				+ ", getSensorType()=" + getSensorType() + "]";
	}
	String deviceType;
	String sensorType;
}
