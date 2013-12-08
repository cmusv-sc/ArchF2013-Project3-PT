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
 * Enum to hold mappings to Restful API verbs
 * @author Team Mercury
 */
enum APIRequestVerb
{
   /** for Category3 API 
    * https://github.com/SensorServicePlatform/APIs#1 
    */
   GET_ALL_DEVICES("get_devices"),
   /** for Category3 API 
    * https://github.com/SensorServicePlatform/APIs#2 
    */
   GET_SENSOR_TYPES("get_sensor_types"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#4 
    * https://github.com/SensorServicePlatform/APIs#5
    * https://github.com/SensorServicePlatform/APIs#20 
    * https://github.com/SensorServicePlatform/APIs#21
    */
   GET_SENSOR_READING("sensors"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#6
    */
   GET_LAST_READINGS("last_readings_from_all_devices"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#7
    * These readings are the most last
    */
   GET_LASTEST_READINGS("lastest_readings_from_all_devices");
   
   
   private final String verbString;
   
   APIRequestVerb(String _verbString)
   {
      verbString = _verbString;
   }
   
   /**
    * Get the enum as string for use in API
    * @return enum value as API string
    */
   protected String getVerbString()
   {
      return verbString;
   }
}
