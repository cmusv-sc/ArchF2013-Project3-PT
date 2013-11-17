package controllers.query;

/**
 * ResponseComponent that represents a Value
 * @author geoffschaeffer
 * @param <T> The type of object value this holds
 */
public class ValueComponent<T> extends ResponseComponent
{
   T value;
   
   protected ValueComponent(T inVal)
   {
      this.value = inVal;
   }
   
   /**
    * @return Component value as <T>
    */
   public T getValue()
   {
      return value;
   }
}
