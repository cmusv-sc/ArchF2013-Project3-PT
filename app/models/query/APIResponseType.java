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

/**
 * Enum to hold mappings to Restful API response types
 * @author Team Mercury
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
