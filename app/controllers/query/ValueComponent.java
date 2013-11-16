package controllers.query;

/**
 * ResponseComponent that represents a Value
 * @author geoffschaeffer
 */
public class ValueComponent extends ResponseComponent
{
   String value;
   
   protected ValueComponent(String strVal)
   {
      this.value = strVal;
   }
   
   /**
    * @return Component value as string
    */
   public String getValue()
   {
      return value;
   }
}
