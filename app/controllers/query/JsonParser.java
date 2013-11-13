package controllers.query;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonParser 
{
   public static ArrayComponent toArrayComponent(JsonNode jsonRoot)
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
      return retArray;
   }

   public static ResponseComponent toCompositeComponent(JsonNode jsonNode)
   {
      CompositeComponent retComp = new CompositeComponent();
      //we are expecting a key-value node here
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
      return retComp;
   }
}
