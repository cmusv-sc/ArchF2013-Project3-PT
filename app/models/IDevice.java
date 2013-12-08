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
 * @responsibilities interface for the encapsulation of a single device object
 *                   returned from platform API calls
 */
public interface IDevice
{
   /**
    * Returns the uri (id) of the device
    * 
    * @return the device id
    */
   public String getDeviceId();

   /**
    * Returns the model of this device
    * 
    * @return the device type
    */
   public DeviceType getDeviceType();

   /**
    * Returns the name of the device agent for this device
    * 
    * @return the name of the agent as a string
    */
   public String getDeviceAgent();

   /**
    * Returns the name of the location of the device
    * 
    * @return the location of the device
    */
   public String getDeviceLocation();
}
