/*
 * Copyright (c) 2013 Carnegie Mellon University Silicon Valley.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available
 * under the terms of dual licensing(GPL V2 for Research/Education
 * purposes). GNU Public License v2.0 which accompanies this distribution
 * is available at http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact http://www.cmu.edu/silicon-valley/ if you have any
 * questions.
 */

package models.query;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Builder class for API requests
 * @author Team Mercury
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
