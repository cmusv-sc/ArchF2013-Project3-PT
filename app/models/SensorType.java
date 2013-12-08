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

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Pure-Java (POJO) Representation of a SensorType.
 * Isolates the business logic of the app from potential changes in the
 * data-access (DAO) layer.
 * 
 * Implements Comparable
 * 
 * A SensorType contains a name identifer
 * 
 * @author Team Mercury
 */
public class SensorType implements Comparable<SensorType>
{
   /** the identifier for this SensorType (e.g. "Temp") */
   private final String sensorType;

   /**
    * Constuctor - requires the sensorType as an identifier
    * @param sensorType
    */
   public SensorType(String sensorType)
   {
      this.sensorType = sensorType;
   }

   /**
    * Gets the type
    * @return the sensorType as string
    */
   public String getType()
   {
      return sensorType;
   }

   /**
    * Static helper to turn a comma-separated string list of sensor types
    * into a Set of SensorType 
    * @param sensorTypeTokens
    * @return Set<SensorType>
    */
   public static Set<SensorType> parseSensorTypeList(
         final String sensorTypeTokens)
   {
      Set<SensorType> sensorTypes = new HashSet<SensorType>();
      if (sensorTypeTokens != null && !sensorTypeTokens.isEmpty())
      {
         StringTokenizer tokenizer = new StringTokenizer(sensorTypeTokens, ",");
         while (tokenizer.hasMoreElements())
         {
            sensorTypes.add(new SensorType(tokenizer.nextToken()));
         }
      }
      return sensorTypes;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (!(o instanceof SensorType))
      {
         return false;
      }
      SensorType st = (SensorType) o;
      return sensorType.equals(st.sensorType);
   }

   @Override
   public int hashCode()
   {
      return sensorType.hashCode();
   }

   public int compareTo(SensorType sType)
   {
      if (this.sensorType != null && sType.sensorType != null)
      {
         return this.sensorType.compareToIgnoreCase(sType.sensorType);
      }
      return 0;
   }

   @Override
   public String toString()
   {
      final StringBuilder sb = new StringBuilder("SensorType{");
      sb.append("sensorType='").append(sensorType).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
