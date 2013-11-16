package controllers.query;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Helper class to parse Json into ResponseComponents
 * @author geoffschaeffer
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
               valComp = new ValueComponent(valNode.textValue());
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
