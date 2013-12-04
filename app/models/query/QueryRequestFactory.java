package models.query;

import models.query.mock.MockQueryRequest;

/**
 * Factory for creating QueryRequests
 * @author Team Mercury
 */
public class QueryRequestFactory
{
   /**
    * get an IQueryRequest
    * @return IQueryRequest
    */
   public static IQueryRequest makeQueryRequest()
   {
      //use this ctor when the API is working
      //return new QueryRequest();

      //use the Mock when the API is down
      return new MockQueryRequest();
   }
}
