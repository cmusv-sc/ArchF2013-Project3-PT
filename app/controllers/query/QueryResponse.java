package controllers.query;

import java.util.Iterator;

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
