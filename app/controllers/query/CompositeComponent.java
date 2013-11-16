package controllers.query;

import java.util.HashMap;

/**
 * ResponseComponent that represents a key->value mapping
 * @author geoffschaeffer
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

   public Map asMap()
   {
      return this.compMap;
   }
}
