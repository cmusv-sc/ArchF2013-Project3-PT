package models.query;

import java.util.Iterator;

/**
 * Standard response to a QueryRequest
 * Provides an iterator over ResponseComponents
 * 
 * ResponseComponents use the Composite pattern to deal with
 * API responses in a general fashion.
 * 
 * @author Team Mercury
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
