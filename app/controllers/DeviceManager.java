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

/**
 * DeviceManager is a controller intermediary between
 * the DAO (Data-Access) layer and the controller. It will construct and supply 
 * the business logic with the POJOs defined in the 'models' package, using the
 * API implementation supplied in the 'models/query' package.
 * 
 * DeviceManager helps to further insulate the Application views from changes in 
 * the DAO layer.
 * 
 * @author Team Mercury
 */
public class DeviceManager
{
   private static final String DEVICE_AGENT = "device_agent";
   public static final String DEVICE_ID = "device_id";
   private static final String DEVICE_LOCATION = "device_location";
   private static final String DEVICE_TYPE = "device_type";
   public static final String END_TIME = "end_time";
   private static final String LAST_READINGS = "last_readings";
   private static final String LASTEST_READINGS = "lastest_readings";
   private static final String POINT_IN_TIME_READING = "point_in_time_reading";
   protected static final String QUERY_TYPE = "query_type";
   public static final String SENSOR_TYPE = "sensor_type";
   public static final String START_TIME = "start_time";
   private static final String TIMESTAMP = "time";
   protected static final String TIMEFRAME_READINGS = "timeframe_readings";
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

   /**
    * Gets the list of DeviceTypes available in the sensor network
    * @return A List of DeviceType
    */
   public List<DeviceType> getDeviceTypes()
   {
      QueryRequest request = new QueryRequest();
      QueryResponse deviceResp = request.getAllDevices();
      Set<DeviceType> deviceTypes = makeDeviceTypeSet(deviceResp);
      deviceTypes = addSensorTypes(request, deviceTypes);
      //take this to List so we can enforce an ordering on it
      List<DeviceType> deviceTypeList = new ArrayList<DeviceType>(deviceTypes);
      java.util.Collections.sort(deviceTypeList);
      return deviceTypeList;
   }

   /**
    * Provide a reverse-lookup of DeviceType by sensor type
    * @param sensorType
    * @param deviceTypeList - assumes we have access to the collection of all DeviceTypes 
    * @return List of DeviceTypes
    */
   public List<DeviceType> getDeviceTypes(SensorType sensorType, List<DeviceType> deviceTypeList)
   {
      //build the reverse mapping of SensorTypes to DeviceType
      Map<SensorType, List<DeviceType>> revMap = makeSensorTypeToDeviceTypeMap(deviceTypeList);
      List<DeviceType> dTypeList = revMap.get(sensorType);
      java.util.Collections.sort(dTypeList);
      return dTypeList;
   }
   
   /**
    * Helper for getDeviceTypes
    * @param deviceTypeList
    * @return Map<SensorType, List<DeviceType>>
    */
   private Map<SensorType, List<DeviceType>> makeSensorTypeToDeviceTypeMap(List<DeviceType> deviceTypeList)
   {
      Map<SensorType, List<DeviceType>> revMap = new HashMap<SensorType, List<DeviceType>>();
      for(DeviceType currDeviceType: deviceTypeList) 
      {
         List<SensorType> sTypeList = currDeviceType.getSensorTypes();
         for(SensorType sType : sTypeList)
         {
            List<DeviceType> typeLookup = revMap.get(sType);
            if(typeLookup == null)
            {
               typeLookup = new ArrayList<DeviceType>();
               typeLookup.add(currDeviceType);
            }
            else
            {
               typeLookup.add(currDeviceType);               
            }
            revMap.put(sType, typeLookup);
         }
      }
      return revMap;
   }

   /**
    * Get the list of DeviceIds for a given DeviceType
    * @param deviceType
    * @return List of Strings (that represent device ids)
    */
   public List<String> getDeviceIds(DeviceType deviceType)
   {
      QueryRequest request = new QueryRequest();
      QueryResponse deviceResp = request.getAllDevices();
      List<String> idList = new ArrayList<String>();
      for(ResponseComponent deviceNode: deviceResp) 
      {
         CompositeComponent compNode = (CompositeComponent) deviceNode;
         String devType = compNode.getValueAsString(DEVICE_TYPE);
         String deviceId = compNode.getValueAsString(URI);
         if (devType != null && devType.equals(deviceType.getType())
                 && deviceId != null && !deviceId.isEmpty())
         {
            idList.add(deviceId);
         }
      }
      return idList;
   }

   /**
    * Get the list of DeviceIds by SensorType
    * @param sensorType
    * @return list of device ids
    */
   public List<String> getDeviceIds(SensorType sensorType)
   {
      List<Device> devices = getDevices();
      List<String> idList = new ArrayList<String>();
      for(Device device: devices)
      {
         if (device.getDeviceType().getSensorTypes().contains(sensorType))
         {
            idList.add(device.getDeviceId());
         }
      }
      return idList;
   }
   
   /**
    * Get a list of SensorTypes by DeviceType
    * @param deviceType
    * @return List of SensorType
    */
   public List<SensorType> getSensorTypes(String deviceType) 
   {
      QueryDeviceArg query = new QueryDeviceArg(deviceType);
      QueryRequest request = new QueryRequest();
      QueryResponse response = request.getSensorTypes(query);
      Set<SensorType> sTypeSet = makeSensorTypeSet(response);
      //take this to List so we can enforce an ordering on it
      List<SensorType> sensorTypeList = new ArrayList<SensorType>(sTypeSet);
      java.util.Collections.sort(sensorTypeList);
      return sensorTypeList;
   }

   /**
    * Route a request for sensor readings to the correct underlying Cat2 API
    * Either: LAST_READINGS, LASTEST_READINGS, TIMEFRAME_READINGS, or
    * POINT_IN_TIME_READINGS
    * @param parameters
    * @return List of SensorReading
    */
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

   /**
    * Get device agents available in the sensor network
    * @return List of String (representing device agents)
    */
   public List<String> getDeviceAgents()
   {
      List<Device> devices = getDevices();
      Set<String> deviceAgentSet = new HashSet<String>();
      for(Device device: devices)
      {
         deviceAgentSet.add(device.getDeviceAgent());
      }
      List<String> deviceAgents = new ArrayList<String>(deviceAgentSet);
      return deviceAgents;
   }

   /**
    * Get sensor types available in the sensor network
    * @return List of String (representing sensor types)
    */
   public List<String> getAllSensorTypes()
   {
      List<Device> devices = getDevices();
      Set<String> sensorTypeSet = new HashSet<String>();
      for(Device device: devices)
      {
         for(SensorType sensorType: device.getDeviceType().getSensorTypes()) {
            sensorTypeSet.add(sensorType.getType());
         }
      }
      List<String> sensorTypes = new ArrayList<String>(sensorTypeSet);
      return sensorTypes;
   }

   /**
    * Helper to make set of deviceTypes
    * @param devices
    * @return Set of DeviceType
    */
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

   /**
    * Helper to make set of sensorTypes
    * @param sensors
    * @return Set of SensorType
    */
   private Set<SensorType> makeSensorTypeSet(QueryResponse sensors)
   {
      Set<SensorType> sensorTypes = new HashSet<SensorType>();
      for (ResponseComponent sensor : sensors)
      {
         CompositeComponent compNode = (CompositeComponent) sensor;
         String sensorTypeTokenizedString = compNode
               .getValueAsString(SENSOR_TYPE);
         if (sensorTypeTokenizedString != null
               && !sensorTypeTokenizedString.isEmpty())
         {
            sensorTypes = SensorType
                  .parseSensorTypeList(sensorTypeTokenizedString);
         }
      }
      return sensorTypes;
   }

   /**
    * Helper to add sensor types to device types
    * @param request
    * @param deviceTypes
    * @return Set of DeviceType
    */
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

   /**
    * Helper to take a list of sensor types as a string to a List
    * @param sensorTypesStr
    * @return List of String (representing sensor types)
    */
   private List<String> parseSensorTypesToList(String sensorTypesStr)
   {
       List<String> retList = new ArrayList<String>();
       if (sensorTypesStr != null && !sensorTypesStr.isEmpty()) {
           retList = Arrays.asList(sensorTypesStr.split(","));
       }

       return retList;
   }
   
   /**
    * Helper to map tag to DeviceType
    * @param deviceTypes
    * @return Map of tag to DeviceType
    */
   private Map<String, DeviceType> makeDeviceTypeMap(Set<DeviceType> deviceTypes)
   {
      Map<String, DeviceType> deviceTypeMap = new HashMap<String, DeviceType>();
      for (DeviceType deviceType : deviceTypes)
      {
         deviceTypeMap.put(deviceType.getType(), deviceType);
      }
      return deviceTypeMap;
   }

   /**
    * Helper to make a List of SensorReading
    * @param response
    * @return List of SensorReading
    */
   private List<SensorReading> makeSensorReadingList(QueryResponse response) 
   {
      List<SensorReading> sensorReadings = new ArrayList<SensorReading>();
      for(ResponseComponent respNode : response) 
      {
         CompositeComponent readingNode = (CompositeComponent) respNode;
          if (readingNode.get(DEVICE_ID)!= null && !readingNode.getValueAsString(DEVICE_ID).isEmpty()) {
              SensorReading sensorReading = new SensorReading(readingNode.getValueAsString(DEVICE_ID),
                                                               readingNode.getValueAsString(SENSOR_TYPE),
                                                               readingNode.getValueAsString(VALUE),
                                                               readingNode.getValueAsString(TIMESTAMP));
               sensorReadings.add(sensorReading);
          }

      }
      return sensorReadings;
   }
}
