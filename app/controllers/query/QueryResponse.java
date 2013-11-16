package controllers.query;

import java.util.Iterator;

/**
 * Standard response to a query
 * Provides an iterator over ResponseComponents
 * @author geoffschaeffer
 */
public class QueryResponse implements Iterable<ResponseComponent>
{
   private ArrayComponent response;
   
   protected QueryResponse(ArrayComponent inArr)
   {
      this.response = inArr;
   }

   public Iterator<ResponseComponent> iterator()
   {
      return response.iterator();
   }
}
