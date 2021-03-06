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

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Helper class to parse Json into ResponseComponents
 * 
 * ResponseComponents use the Composite pattern to deal with
 * API responses in a general fashion.
 * 
 * If the API stops communicating in JSON, the response could still
 * be converted into a collection of ResponseComponents, ensuring that
 * downstream classes would not have to change (mostly QueryResponse).
 * 
 * @author Team Mercury
 */
class JsonParser 
{
   protected static ArrayComponent toArrayComponent(JsonNode jsonRoot)
   {
      ArrayComponent retArray = new ArrayComponent();
      //expecting an ArrayNode
      if(jsonRoot.isArray())
      {
         Iterator<JsonNode> jsonIter = jsonRoot.iterator();
         while(jsonIter.hasNext())
         {
            JsonNode currNode = jsonIter.next();
            ResponseComponent currResp = toCompositeComponent(currNode);
            retArray.add(currResp);
         }
      }
      else if(jsonRoot.isObject())
      {
         //have an object instead - wrap it in an array
         ResponseComponent newComp = toCompositeComponent(jsonRoot);
         retArray.add(newComp);
      }
      return retArray;
   }

   protected static ResponseComponent toCompositeComponent(JsonNode jsonNode)
   {
      CompositeComponent retComp = new CompositeComponent();
      //we are expecting a key-value node here
      if(jsonNode.isObject())
      {
         Iterator<Map.Entry<String,JsonNode>> fieldIter = jsonNode.fields();
         while(fieldIter.hasNext())
         {
            Map.Entry<String,JsonNode> currEntry = fieldIter.next();
            JsonNode valNode = currEntry.getValue();
            ResponseComponent valComp; 
            if(valNode.isValueNode())
            {
               valComp = new ValueComponent<String>(valNode.asText());
            }
            else if(valNode.isArray())
            {
               valComp = toArrayComponent(valNode);
            }
            else
            {
               valComp = toCompositeComponent(valNode);
            }
            retComp.put(currEntry.getKey(), valComp);
         }
      }
      return retComp;
   }
}
