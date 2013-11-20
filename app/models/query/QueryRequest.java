package models.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.WS;

/**
 * This class houses the low-level interface with the Sensor API
 * @author geoffschaeffer
 */
public class QueryRequest 
{
   /**
    * Builds and executes Cat3 API
    * https://github.com/SensorServicePlatform/APIs#1
    * @return QueryResponse
    */
   public QueryResponse getAllDevices()
   {
      QueryResponse retVal = null;

      //impl of Category 3 API - get all devices
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_ALL_DEVICES);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }

   /**
    * Builds and executes Cat3 API
    * https://github.com/SensorServicePlatform/APIs#2
    * @param dType 
    * @return QueryResponse
    */
   public QueryResponse getSensorTypes(QueryDeviceArg dType)
   {
      QueryResponse retVal = null;
      
      //impl of Category 3 API
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_SENSOR_TYPES);
      request.addDeviceArg(dType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }

   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#4
    * https://github.com/SensorServicePlatform/APIs#20
    * @param device
    * @param sensorType
    * @param timePoint
    * @return QueryResponse
    */
   public QueryResponse getSensorReadingByTimePoint(QueryDeviceArg device, 
                                                    QuerySensorTypeArg sensorType,
                                                    QueryTimeArg timePoint)
   {
      QueryResponse retVal = null;
      
      //impl of time-point based requests - CAT2 APIs
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_SENSOR_READING);
      request.addDeviceArg(device);
      request.addTimeArg(timePoint);
      request.addSensorTypeArg(sensorType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }

   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#5
    * https://github.com/SensorServicePlatform/APIs#21
    * @param device
    * @param sensorType
    * @param startTime 
    * @param endTime 
    * @return QueryResponse
    */
   public QueryResponse getSensorReadingByTimeRange(QueryDeviceArg device, 
                                                    QuerySensorTypeArg sensorType,
                                                    QueryTimeArg startTime,
                                                    QueryTimeArg endTime)
   {
      QueryResponse retVal = null;
      
      //impl of time-point based requests - CAT2 APIs
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_SENSOR_READING);
      request.addDeviceArg(device);
      request.addTimeArg(startTime);
      request.addTimeArg(endTime);
      request.addSensorTypeArg(sensorType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }
   
   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#6
    * @param sensorType
    * @param timePoint
    * @return QueryResponse
    */
   public QueryResponse getLastReadings(QuerySensorTypeArg sensorType,
                                        QueryTimeArg timePoint)
   {
      QueryResponse retVal = null;
      
      //impl of time-point based requests - CAT2 APIs
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_LAST_READINGS);
      request.addTimeArg(timePoint);
      request.addSensorTypeArg(sensorType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }
   
   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#7
    * @param sensorType
    * @return QueryResponse
    */
   public QueryResponse getLastestReadings(QuerySensorTypeArg sensorType)
   {
      QueryResponse retVal = null;
      
      //impl of time-point based requests - CAT2 APIs
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_LASTEST_READINGS);
      request.addSensorTypeArg(sensorType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }
   
   private QueryResponse executeGetRequest(APIRequestBuilder request)
   {
      QueryResponse retVal = null;
      
      String requestUrl = request.toString();
            
      //go synchronus for ease of impl
      WS.Response response = WS.url(requestUrl).get().get(DEFAULT_TIMEOUT);
      
      JsonNode apiResponseJson = null;
      String apiResponseString = response.getBody();
      //Hacky way to get around the fact that it is tough
      //to catch a JsonParseException from Play internals
      if(!responseIsError(apiResponseString))
      {
         apiResponseJson = response.asJson();
      }
      
      if(apiResponseJson != null)
      {
         retVal = new QueryResponse(JsonParser.toArrayComponent(apiResponseJson));
      }
      else
      {
         //swallow up errors and return an empty array
         retVal = new QueryResponse(new ArrayComponent());
      }
      
      return retVal;
   }
   
   private boolean responseIsError(String respStr)
   {
      boolean isErr = false;
      
      if(respStr == null)
      {
         isErr = true;
      }
      
      if(respStr.contains(SENSOR_ERROR_STR))
      {
         isErr = true;
      }
      
      return isErr;
   }
   
   //--------------------------------------------------------------------------

   private static long DEFAULT_TIMEOUT = 5000;
   private static String SENSOR_ERROR_STR = "No sensor type found for";
}
