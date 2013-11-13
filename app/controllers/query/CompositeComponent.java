package controllers.query;

import java.util.HashMap;

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
   
   public ResponseComponent get(String key)
   {
      return compMap.get(key);
   }
}
