/*
 * Copyright (c) 2013 Carnegie Mellon University Silicon Valley.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available
 * under the terms of dual licensing(GPL V2 for Research/Education
 * purposes). GNU Public License v2.0 which accompanies this distribution
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact http://www.cmu.edu/silicon-valley/ if you have any
 * questions.
 */

package models.query;

import com.fasterxml.jackson.databind.JsonNode;

import play.Logger;
import play.libs.Json;
import play.libs.WS;

/**
 * This class houses the low-level interface with the Sensor API
 * Currently, the data access is done via the HTTP APIs at:
 * https://github.com/SensorServicePlatform
 * 
 * However, if this implementation changes in the future, downstream classes
 * (in the Manager or POJO layer) should require no (or minimal) changes
 * 
 * QueryRequest will execute different APIs. It expects different Query*Args
 * (API arguments wrapped in a Java object) and returns a QueryResponse.
 * 
 * @author Team Mercury
 */
public class QueryRequest implements IQueryRequest
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
       Logger.info("Request: " + requestUrl);

            
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
   
   /**
    * Helper to convert a json-formatted string into a QueryResponse
    * Mostly for use in mocks and tests
    * @param jsonResponse
    * @return QueryResponse
    */
   public static QueryResponse jsonStringToResponse(String jsonResponse)
   {
      QueryResponse retVal;
      JsonNode convNode = Json.parse(jsonResponse);
      
      retVal = new QueryResponse(JsonParser.toArrayComponent(convNode));
      
      return retVal;
   }
   
   //--------------------------------------------------------------------------

   private static final long DEFAULT_TIMEOUT = 30000;
   private static final String SENSOR_ERROR_STR = "No sensor type found for";
}
