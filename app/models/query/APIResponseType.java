package models.query;

/**
 * Enum to hold mappings to Restful API response types
 * @author geoffschaeffer
 */
enum APIResponseType
{
   /** JSON response */
   JSON("json");
   
   private final String respString;
   
   APIResponseType(String _respString)
   {
      respString = _respString;
   }
   
   /**
    * Get the enum as string for use in API
    * @return enum value as API string
    */
   protected String getResponseString()
   {
      return respString;
   }
}
