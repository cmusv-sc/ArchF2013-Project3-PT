package controllers;

import controllers.query.QueryRequest;
import controllers.query.QueryResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueryManager {

  private static final String DEVICE_TYPE = "device_type";

  public List<Device> getDevices() {
    QueryRequest request = new QueryRequest();
    QueryResponse devicesResponse = request.getAllDevices();
    Set deviceTypeNames = new HashSet();
    for(ResponseComponent device: devicesResponse) {
      deviceTypeNames.add(device.get(DEVICE_TYPE).getValue());
    }
    Map deviceTypes = new HashMap();
    QueryResponse dTypeResponse;
    for(String deviceTypeName: deviceTypeNames) {
      dTypeResponse = request.getSensorTypes(deviceTypeName);
      DeviceType dType = new DeviceType(deviceTypeName);
      for (String sensorName 
      deviceTypes.put(
        deviceTypeName, 
        new DeviceType(deviceTypeName, deviceTypeResponse.sensorTypes)
    }
    List devices = new ArrayList();
    for(ResponseComponent device: devicesResponse.components) {
      
      devices.add(
    }
  }

  public List<SensorReading> getSensorReadings(Map parameters) {
  
  }
} 
