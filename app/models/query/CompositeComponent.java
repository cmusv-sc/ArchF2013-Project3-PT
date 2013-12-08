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

import java.util.HashMap;

/**
 * ResponseComponent that represents a key->value mapping
 * 
 * ResponseComponents use the Composite pattern to deal with
 * API responses in a general fashion.
 * 
 * @author Team Mercury
 */
public class CompositeComponent extends ResponseComponent
{
   HashMap<String, ResponseComponent> compMap;
   
   protected CompositeComponent()
   {
      this.compMap = new HashMap<String, ResponseComponent>();
   }
   
   protected void put(String key, ResponseComponent value)
   {
      compMap.put(key, value);
   }
   
   /**
    * @param key
    * @return ResponseComponent that has the supplied key
    */
   public ResponseComponent get(String key)
   {
      return compMap.get(key);
   }
   
   /**
    * Helper to directly access the value as a string
    * @param key
    * @return value as string
    */
   public String getValueAsString(String key)
   {
      String retVal = null;
      ResponseComponent resp = compMap.get(key);
      if (resp instanceof ValueComponent<?>)
      {
         @SuppressWarnings("unchecked")
         ValueComponent<String> valResp = (ValueComponent<String>) resp;
         retVal = valResp.getValue();
      }
      return retVal;
   }
}
