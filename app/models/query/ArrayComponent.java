package models.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ResponseComponent that represents an Array of components
 * @author geoffschaeffer
 */
public class ArrayComponent extends ResponseComponent implements Iterable<ResponseComponent>
{
   private List<ResponseComponent> theArray;
   
   protected ArrayComponent()
   {
      this.theArray = new ArrayList<ResponseComponent>();
   }
   
   protected void add(ResponseComponent comp)
   {
      theArray.add(comp);
   }
   
   /**
    * @param index
    * @return the component at index of the Array
    */
   public ResponseComponent get(int index)
   {
      return theArray.get(index);
   }
   
   public Iterator<ResponseComponent> iterator()
   {
      return theArray.iterator();
   }
}
