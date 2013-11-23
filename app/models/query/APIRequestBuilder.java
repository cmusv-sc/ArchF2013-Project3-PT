package models.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

   protected void addTimeArg(QueryTimeArg arg)
   {
      bldr.append(URL_SEP);
      bldr.append(arg.toString());
   }
   
   protected void addDeviceArg(QueryDeviceArg arg)
   {
      bldr.append(URL_SEP);
      bldr.append(urlEncodeArg(arg.toString()));
   }
   
   protected void addSensorTypeArg(QuerySensorTypeArg arg)
   {
      bldr.append(URL_SEP);
      bldr.append(urlEncodeArg(arg.toString()));
   }
   
   private String urlEncodeArg(String argString)
   {
      String encodeStr = null;
      try
      {
         encodeStr = URLEncoder.encode(argString, "UTF-8");
      }
      catch(UnsupportedEncodingException uee)
      {
         //make it barf later on a badly encoded string
         encodeStr = argString;
      }
      return encodeStr;
   }
   
   public String toString()
   {
      return bldr.toString();
   }
   
   //--------------------------------------------------------------------------

   private static final String SITE_URL = "http://einstein.sv.cmu.edu";
   private static final String URL_SEP = "/";
}
