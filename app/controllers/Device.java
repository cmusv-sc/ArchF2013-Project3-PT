package controllers;

public class Device implements IDevice {
	public Device(){};
	public Device(String deviceId,
				  String deviceType,
				  String deviceAgent,
				  String deviceLocation)
	{
		this.deviceId 	 	= deviceId;
		this.deviceType  	= deviceType;
		this.deviceAgent 	= deviceAgent;
		this.deviceLocation = deviceLocation;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceAgent() {
		return deviceAgent;
	}
	public void setDeviceAgent(String deviceAgent) {
		this.deviceAgent = deviceAgent;
	}
	public String getDeviceLocation() {
		return deviceLocation;
	}
	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}

	
	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceType=" + deviceType
				+ ", deviceAgent=" + deviceAgent + ", deviceLocation="
				+ deviceLocation + ", getDeviceId()=" + getDeviceId()
				+ ", getDeviceType()=" + getDeviceType()
				+ ", getDeviceAgent()=" + getDeviceAgent()
				+ ", getDeviceLocation()=" + getDeviceLocation() + "]";
	}



	String deviceId;
	String deviceType;
	String deviceAgent;
	String deviceLocation;
}
