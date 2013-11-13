package controllers.query;

public class ValueComponent extends ResponseComponent
{
   String value;
   
   protected ValueComponent(String strVal)
   {
      this.value = strVal;
   }
   
   public String getValue()
   {
      return value;
   }
}
