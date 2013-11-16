package controllers;

import query.ArrayComponent;
import query.CompositeComponent;
import query.QueryDeviceArg;
import query.QueryRequest;
import query.QueryResponse;
import query.QuerySensorTypeArg;
import query.QueryTimeArg;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceManager {

  private static final String DEVICE_AGENT = "device_agent";
  private static final String DEVICE_ID = "device_id";
  private static final String DEVICE_LOCATION = "device_location";
  private static final String DEVICE_TYPE = "device_type";
  private static final String END_TIME = "end_time";
  private static final String LAST_READINGS = "last_readings";
  private static final String LATEST_READINGS = "latest_readings";
  private static final String POINT_IN_TIME_READING = "point_in_time_reading";
  private static final String QUERY_TYPE = "query_type";
  private static final String SENSOR_TYPE = "sensor_type";
  private static final String START_TIME = "start_time";
  private static final String TIMESTAMP = "time";
  private static final String TIMEFRAME_READINGS = "timeframe_readings";
  private static final String URI = "uri";
  private static final String VALUE = "value";

  public List<Device> getDevices() {
    QueryRequest request = new QueryRequest();
    QueryResponse deviceResp = request.getAllDevices();
    Set deviceTypes = makeDeviceTypeSet(deviceResp);
    deviceTypes = addSensorTypes(request, deviceTypes);
    Map deviceTypeMap = makeDeviceTypeMap(deviceTypes);
    List<Device> devices = new ArrayList();
    for(CompositeComponent (CompositeComponent)deviceNode: deviceResp) {
      Device device = new Device(
          deviceNode.get(URI),
          deviceTypeMap.get(deviceNode.get(DEVICE_TYPE)),
          deviceNode.get(DEVICE_AGENT),
          deviceNode.get(DEVICE_LOCATION));
      devices.add(device);
    }
    return devices;
  }

  public List<SensorReading> getSensorReadings(Map parameters) {
    String queryType = parameters.get(QUERY_TYPE);
    QueryRequest request = new QueryRequest();
    QueryResponse response = null;
    if(queryType.equals(LAST_READINGS)) {
      QuerySensorTypeArg sensorType =
          new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
      QueryTimeArg time = new QueryTimeArg(parameters.get(TIMESTAMP));
      response = request.getLastReadings(sensorType, time);
    } else if (queryType.equals(LATEST_READINGS)) {
      QuerySensorTypeArg sensorType =
          new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
      response = request.getLatestReading(sensor_type);
    } else if (queryType.equals(TIMEFRAME_READINGS)) {
      QueryDeviceArg device = new QueryDeviceArg(parameters.get(DEVICE_ID));
      QuerySensorTypeArg sensorType =
          new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
      QueryTimeArg startTime = new QueryTimeArg(parameters.get(START_TIME));
      QueryTimeArg endTime = new QueryTimeArg(parameters.get(END_TIME));
      response = request.getSensorReadingsByTimeRange(
          device, sensorType, startTime, endTime);
    } else if (queryType.equals(POINT_IN_TIME_READING)) {
      QueryDeviceArg device = new QueryDeviceArg(parameters.get(DEVICE_ID));
      QuerySensorTypeArg sensorType =
          new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
      QueryTimeArg time = new QueryTimeArg(parameters.get(TIMESTAMP));
      response = request.getSensorReadingByTimePoint(device, sensorType, time);
    } else {
      throw new RuntimeException("Not a valid query");
    }
    return makeSensorReadingsList(response);
  }

  private Set makeDeviceTypeSet(QueryResponse devices) {
    Set deviceTypes = new HashSet();
    for(CompositeComponent (CompositeComponent)deviceNode: devices) {
      device = new DeviceType(deviceNode.get(DEVICE_TYPE).getValue());
      deviceTypes.add(device);
    }
    return deviceTypes;
  }

  private Set addSensorTypes(QueryRequest request, Set deviceTypes) {
    QueryResponse sensorTypeResp;
    for(DeviceType deviceType: deviceTypes) {
      deviceTypeArg = new QueryDeviceArg(deviceType.getType());
      sensorTypeResp = request.getSensorTypes(deviceTypeArg);
      ArrayComponent sensorTypes = (ArrayComponent)(
          (CompositeComponent)sensorTypeResp.next())
          .get(SENSOR_TYPES);
      for(String sensorTypeName: sensorTypes) {
        SensorType sensorType = new SensorType(sensorTypeName);
        deviceType.add(sensorType); 
      }
    }
    return deviceTypes;
  }

  private Map makeDeviceTypeMap(Set deviceTypes) {
    Map deviceTypeMap = new HashMap();
    for(DeviceType deviceType: deviceTypes) {
      deviceTypeMap.put(deviceType.getType(), deviceType);
    }
    return deviceTypeMap;
  }

  private List<SensorReading> makeSensorReadingList(QueryResponse response) {
    List<SensorReading> sensorReadings = new ArrayList();
    for(CompositeComponent (CompositeComponent) readingNode: response) {
      sensorReading = new SensorReading(
          readingNode.get(DEVICE_ID),
          readingNode.get(SENSOR_TYPE),
          readingNode.get(VALUE),
          readingNode.get(TIMESTAMP));
      sensorReadings.add(sensorReading);     
    }
    return sensorReadings;
  }
} 
