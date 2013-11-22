package controllers;

import models.query.CompositeComponent;
import models.query.QueryDeviceArg;
import models.query.QueryRequest;
import models.query.QueryResponse;
import models.query.QuerySensorTypeArg;
import models.query.QueryTimeArg;
import models.query.ResponseComponent;
import models.Device;
import models.DeviceType;
import models.SensorReading;
import models.SensorType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeviceManager
{
   private static final String DEVICE_AGENT = "device_agent";
   private static final String DEVICE_ID = "device_id";
   private static final String DEVICE_LOCATION = "device_location";
   private static final String DEVICE_TYPE = "device_type";
   private static final String END_TIME = "end_time";
   private static final String LAST_READINGS = "last_readings";
   private static final String LASTEST_READINGS = "lastest_readings";
   private static final String POINT_IN_TIME_READING = "point_in_time_reading";
   private static final String QUERY_TYPE = "query_type";
   private static final String SENSOR_TYPE = "sensor_type";
   private static final String START_TIME = "start_time";
   private static final String TIMESTAMP = "time";
   private static final String TIMEFRAME_READINGS = "timeframe_readings";
   private static final String URI = "uri";
   private static final String VALUE = "value";

   /**
    * Gets the devices available in the sensor network
    * @return a list of devices
    */
   public List<Device> getDevices()
   {
      QueryRequest request = new QueryRequest();
      QueryResponse deviceResp = request.getAllDevices();
      Set<DeviceType> deviceTypes = makeDeviceTypeSet(deviceResp);
      deviceTypes = addSensorTypes(request, deviceTypes);
      Map<String, DeviceType> deviceTypeMap = makeDeviceTypeMap(deviceTypes);
      List<Device> devices = new ArrayList<Device>();
      for (ResponseComponent deviceNode : deviceResp)
      {
         CompositeComponent compNode = (CompositeComponent) deviceNode;
         Device device = new Device(compNode.getValueAsString(URI),
                                    deviceTypeMap.get(compNode.getValueAsString(DEVICE_TYPE)),
                                    compNode.getValueAsString(DEVICE_AGENT),
                                    compNode.getValueAsString(DEVICE_LOCATION));
         devices.add(device);
      }
      return devices;
   }

   public List<DeviceType> getDeviceTypes()
   {
      QueryRequest request = new QueryRequest();
      QueryResponse deviceResp = request.getAllDevices();
      Set<DeviceType> deviceTypes = makeDeviceTypeSet(deviceResp);
      deviceTypes = addSensorTypes(request, deviceTypes);
      List<DeviceType> deviceTypeList = new ArrayList<DeviceType>(deviceTypes);
      return deviceTypeList;
   }

    public Set<SensorType> getSensorTypes(String deviceType) {
        QueryDeviceArg query = new QueryDeviceArg(deviceType);
        QueryRequest request = new QueryRequest();
        QueryResponse response = request.getSensorTypes(query);
        return makeSensorTypeSet(response);
    }

   public List<SensorReading> getSensorReadings(Map<String, String> parameters)
   {
      String queryType = parameters.get(QUERY_TYPE);
      QueryRequest request = new QueryRequest();
      QueryResponse response = null;
       switch (queryType) {
           case LAST_READINGS: {
               QuerySensorTypeArg sensorType =
                       new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
               QueryTimeArg time = new QueryTimeArg(parameters.get(TIMESTAMP));
               response = request.getLastReadings(sensorType, time);
               break;
           }
           case LASTEST_READINGS: {
               QuerySensorTypeArg sensorType =
                       new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
               response = request.getLastestReadings(sensorType);
               break;
           }
           case TIMEFRAME_READINGS: {
               QueryDeviceArg device = new QueryDeviceArg(parameters.get(DEVICE_ID));
               QuerySensorTypeArg sensorType =
                       new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
               QueryTimeArg startTime = new QueryTimeArg(parameters.get(START_TIME));
               QueryTimeArg endTime = new QueryTimeArg(parameters.get(END_TIME));
               response = request.getSensorReadingByTimeRange(device, sensorType,
                       startTime, endTime);
               break;
           }
           case POINT_IN_TIME_READING: {
               QueryDeviceArg device = new QueryDeviceArg(parameters.get(DEVICE_ID));
               QuerySensorTypeArg sensorType =
                       new QuerySensorTypeArg(parameters.get(SENSOR_TYPE));
               QueryTimeArg time = new QueryTimeArg(parameters.get(TIMESTAMP));
               response = request.getSensorReadingByTimePoint(device, sensorType,
                       time);
               break;
           }
           default:
               throw new RuntimeException("Not a valid query");
       }
      return makeSensorReadingList(response);
   }

   private Set<DeviceType> makeDeviceTypeSet(QueryResponse devices) 
   {
      Set<DeviceType> deviceTypes = new HashSet<DeviceType>();
      for(ResponseComponent deviceNode: devices) 
      {
         CompositeComponent compNode = (CompositeComponent) deviceNode;
         String devType = compNode.getValueAsString(DEVICE_TYPE);
         if(devType != null)
         {
            DeviceType device = new DeviceType(devType);
            deviceTypes.add(device);
         }
      }
      return deviceTypes;
   }

    private Set<SensorType> makeSensorTypeSet(QueryResponse sensors) {
        Set<SensorType> sensorTypes = new HashSet<SensorType>();
        for (ResponseComponent sensor : sensors) {
            CompositeComponent compNode = (CompositeComponent) sensor;
            String sensorTypeTokenizedString = compNode.getValueAsString(SENSOR_TYPE);
            if (sensorTypeTokenizedString != null && !sensorTypeTokenizedString.isEmpty()) {
                sensorTypes = SensorType.parseSensorTypeList(sensorTypeTokenizedString);
            }
        }
        return sensorTypes;
    }

   private Set<DeviceType> addSensorTypes(QueryRequest request, Set<DeviceType> deviceTypes)
   {
      QueryResponse sensorTypeResp;
      for (DeviceType deviceType : deviceTypes)
      {
         QueryDeviceArg deviceTypeArg = new QueryDeviceArg(deviceType.getType());
         QueryRequest currRequest = new QueryRequest();
         sensorTypeResp = currRequest.getSensorTypes(deviceTypeArg);
         
         for(ResponseComponent sTypeNode : sensorTypeResp)
         {
            CompositeComponent compNode = (CompositeComponent) sTypeNode;
            String sensorTypesStr = compNode.getValueAsString(SENSOR_TYPE);
            List<String> sensorTypes = parseSensorTypesToList(sensorTypesStr);
            for (String sensorTypeName : sensorTypes)
            {
               SensorType sensorType = new SensorType(sensorTypeName);
               deviceType.add(sensorType);
            }
         }
      }
      return deviceTypes;
   }

   private List<String> parseSensorTypesToList(String sensorTypesStr)
   {
      List<String> retList = Arrays.asList(sensorTypesStr.split(","));

      return retList;
   }
   
   private Map<String, DeviceType> makeDeviceTypeMap(Set<DeviceType> deviceTypes)
   {
      Map<String, DeviceType> deviceTypeMap = new HashMap<String, DeviceType>();
      for (DeviceType deviceType : deviceTypes)
      {
         deviceTypeMap.put(deviceType.getType(), deviceType);
      }
      return deviceTypeMap;
   }

   private List<SensorReading> makeSensorReadingList(QueryResponse response) 
   {
      List<SensorReading> sensorReadings = new ArrayList<SensorReading>();
      for(ResponseComponent respNode : response) 
      {
         CompositeComponent readingNode = (CompositeComponent) respNode;
         SensorReading sensorReading = new SensorReading(readingNode.getValueAsString(DEVICE_ID),
                                                         readingNode.getValueAsString(SENSOR_TYPE),
                                                         readingNode.getValueAsString(VALUE),
                                                         readingNode.getValueAsString(TIMESTAMP));
         sensorReadings.add(sensorReading);     
      }
      return sensorReadings;
   }
}
