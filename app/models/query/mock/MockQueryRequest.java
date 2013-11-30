package models.query.mock;

import models.query.IQueryRequest;
import models.query.QueryDeviceArg;
import models.query.QueryRequest;
import models.query.QueryResponse;
import models.query.QuerySensorTypeArg;
import models.query.QueryTimeArg;

/**
 * Mock implementation for using the QueryRequest class in other tests.
 * Currently, the HTTP API is unreliable as to when it is accessible or not,
 * so basing tests off of such an expensive and unreliable resource would
 * be irresponsible.
 * 
 * @author Team Mercury
 */
public class MockQueryRequest implements IQueryRequest
{
   public QueryResponse getAllDevices()
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_ALLDEVICES_JSON);
      return retVal;
   }

   public QueryResponse getSensorTypes(QueryDeviceArg dType)
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_SENSORTYPES_JSON);
      return retVal;
   }

   public QueryResponse getSensorReadingByTimePoint(QueryDeviceArg device, 
                                                    QuerySensorTypeArg sensorType,
                                                    QueryTimeArg timePoint)
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_TIMEPOINT_JSON);
      return retVal;
   }

   public QueryResponse getSensorReadingByTimeRange(QueryDeviceArg device, 
                                                    QuerySensorTypeArg sensorType,
                                                    QueryTimeArg startTime,
                                                    QueryTimeArg endTime)
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_TIMERANGE_JSON);
      return retVal;
   }
   
   public QueryResponse getLastReadings(QuerySensorTypeArg sensorType,
                                        QueryTimeArg timePoint)
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_LAST_JSON);
      return retVal;
   }
   
   public QueryResponse getLastestReadings(QuerySensorTypeArg sensorType)
   {
      QueryResponse retVal = null;
      retVal = QueryRequest.jsonStringToResponse(MOCK_LASTEST_JSON);
      return retVal;
   }
   
   //currently, these don't have json, since the API is down
   private static final String MOCK_ALLDEVICES_JSON = "";
   private static final String MOCK_SENSORTYPES_JSON = "";
   private static final String MOCK_TIMEPOINT_JSON = "";
   private static final String MOCK_TIMERANGE_JSON = "";
   private static final String MOCK_LAST_JSON = "";
   private static final String MOCK_LASTEST_JSON = "";
}
