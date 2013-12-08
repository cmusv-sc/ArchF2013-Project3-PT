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
   
   private static final String MOCK_ALLDEVICES_JSON = "[{\"device_type\":\"Firefly_v3\",\"device_location\":\"B23.216\",\"device_agent\":\"SensorAndrew2\",\"uri\":\"10170202\"}]";
   
   private static final String MOCK_SENSORTYPES_JSON = "{\"device_type\":\"Firefly_v3\", \"sensor_type\":\"temp,digital_temp,light,pressure,humidity,motion,audio_p2p,acc_x,acc_y,acc_z\"}";
   
   private static final String MOCK_TIMEPOINT_JSON = "{\"timestamp\":1368568896000,\"sensor_type\":\"temp\",\"value\":518,\"device_id\":\"10170102\"}";
   
   private static final String MOCK_TIMERANGE_JSON = "[{\"timestamp\":1358568993000,\"sensor_type\":\"temp\",\"value\":218,\"device_id\":\"10170102\"}, {\"timestamp\":1368568896000,\"sensor_type\":\"temp\",\"value\":518,\"device_id\":\"10170102\"}]";
   
   private static final String MOCK_LAST_JSON = "[{\"timestamp\":1368568896000,\"sensor_type\":\"temp\",\"value\":518,\"device_id\":\"10170102\"}]";
   
   private static final String MOCK_LASTEST_JSON = "[{\"timestamp\":1368568896000,\"sensor_type\":\"temp\",\"value\":518,\"device_id\":\"10170102\"}]";
}
