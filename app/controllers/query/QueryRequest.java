package controllers.query;

import play.libs.WS;

public class QueryRequest 
{
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
