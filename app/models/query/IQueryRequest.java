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

/**
 * QueryRequest Interface to make it easy to switch
 * between real QueryRequest and MockQueryRequest in testing
 * @author Team Mercury
 */
public interface IQueryRequest
{
   /**
    * Builds and executes Cat3 API
    * https://github.com/SensorServicePlatform/APIs#1
    * @return QueryResponse
    */
   public QueryResponse getAllDevices();
   
   /**
    * Builds and executes Cat3 API
    * https://github.com/SensorServicePlatform/APIs#2
    * @param dType 
    * @return QueryResponse
    */
   public QueryResponse getSensorTypes(QueryDeviceArg dType);
   
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
                                                    QueryTimeArg timePoint);
   
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
                                                    QueryTimeArg endTime);
   
   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#6
    * @param sensorType
    * @param timePoint
    * @return QueryResponse
    */
   public QueryResponse getLastReadings(QuerySensorTypeArg sensorType,
                                        QueryTimeArg timePoint);
   
   /**
    * Builds and executes Cat2 API
    * https://github.com/SensorServicePlatform/APIs#7
    * @param sensorType
    * @return QueryResponse
    */
   public QueryResponse getLastestReadings(QuerySensorTypeArg sensorType);
}
