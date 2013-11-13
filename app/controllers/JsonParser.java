package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonParser 
{
   public static List<QueryResponse> toResponseList(JsonNode jsonRoot)
   {
      ArrayList<QueryResponse> retList = new ArrayList<QueryResponse>();
      //expecting an ArrayNode
      Iterator<JsonNode> jsonIter = jsonRoot.iterator();
      while(jsonIter.hasNext())
      {
         JsonNode currNode = jsonIter.next();
         QueryResponse currResp = toResponse(currNode);
         retList.add(currResp);
      }
      return retList;
   }

   public static QueryResponse toResponse(JsonNode jsonRoot)
   {
      //expecting ObjectNode
      QueryResponse qr = new QueryResponse();
      Iterator<Map.Entry<String,JsonNode>> fieldIter = jsonRoot.fields();
      while(fieldIter.hasNext())
      {
         Map.Entry<String,JsonNode> currEntry = fieldIter.next();
         
      }
      return qr;
   }
}
