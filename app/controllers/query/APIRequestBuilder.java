package controllers.query;

/**
 * Builder class for API requests
 * @author geoffschaeffer
 */
class APIRequestBuilder
{
   private StringBuilder bldr;
   
   protected APIRequestBuilder()
   {
      bldr = new StringBuilder();
      bldr.append(SITE_URL);
   }
   
   protected void addVerb(APIRequestVerb verb)
   {
      bldr.append(URL_SEP);
      bldr.append(verb.getVerbString());
   }
   
   protected void addResponseType(APIResponseType resp)
   {
      bldr.append(URL_SEP);
      bldr.append(resp.getResponseString());
   }
   
   protected void addStringArg(String arg)
   {
      bldr.append(URL_SEP);
      bldr.append(arg);
   }

   public String toString()
   {
      return bldr.toString();
   }
   
   //--------------------------------------------------------------------------

   private static final String SITE_URL = "http://einstein.sv.cmu.edu";
   private static final String URL_SEP = "/";
}
