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
 * QueryArgs are java object wrappers around arguments to API calls.
 * The specific type of the value of the argument is abstracted by 
 * the QueryArg wrapper allowing for flexibility in implementing new
 * APIs.
 * 
 * Currently all the Query*Args are wrappers around string
 * This superclass provides a common place for that functionality
 * 
 * @author Team Mercury
 */
abstract class QueryArg
{
   private String argStr;
   
   /**
    * String-based ctor
    * @param _inStr
    */
   QueryArg(String _inStr)
   {
      argStr = _inStr;
   }
   
   public String toString()
   {
      return argStr;
   }
}
