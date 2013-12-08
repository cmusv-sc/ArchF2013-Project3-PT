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

package models;

/**
 * @author Team Mercury
 * 
 * @responsibilities interface for the encapsulation of a sensor object returned
 *                   from platform API calls
 */
public interface ISensor
{
   /**
    * Returns the sensor type of the sensor
    * 
    * @return the sensor type as a string
    */
   public String getSensorType();

   /**
    * Returns the name of the device type for the sensor
    * 
    * @return the name of the agent as a string
    */
   public String getDeviceType();
}
