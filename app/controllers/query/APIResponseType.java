package controllers.query;

public enum APIResponseType
{
   JSON("json");
   
   private final String respString;
   
   APIResponseType(String _respString)
   {
      respString = _respString;
   }
   
   public String getResponseString()
   {
      return respString;
   }
}
