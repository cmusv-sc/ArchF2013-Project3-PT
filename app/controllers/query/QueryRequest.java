package controllers.query;

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
   public QueryResponse getSensorTypes(String dType)
   {
      QueryResponse retVal = null;
      
      //impl of Category 3 API
      APIRequestBuilder request = new APIRequestBuilder();
      request.addVerb(APIRequestVerb.GET_SENSOR_TYPES);
      request.addStringArg(dType);
      request.addResponseType(APIResponseType.JSON);

      retVal = executeGetRequest(request);

      return retVal;
   }

   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#4
    * @param device
    * @param sensorType
    * @param timeframe
    * @return QueryResponse
    */
   public QueryResponse getSensorReadingByTime(String device, 
                                               String sensorType,
                                               TimeArg timeframe)
   {
      /* impl of time-based sensor reading requests */
      return null;
   }

   private QueryResponse executeGetRequest(APIRequestBuilder request)
   {
      QueryResponse retVal = null;
      
      String requestUrl = request.toString();
      
      //go synchronus for ease of impl
      WS.Response response = WS.url(requestUrl).get().get(DEFAULT_TIMEOUT);
      
      retVal = new QueryResponse(JsonParser.toArrayComponent(response.asJson()));
      
      return retVal;
   }
   
   //--------------------------------------------------------------------------

   private static long DEFAULT_TIMEOUT = 5000;
}
