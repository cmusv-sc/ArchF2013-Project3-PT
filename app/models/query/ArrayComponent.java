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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ResponseComponent that represents an Array of components
 * 
 * ResponseComponents use the Composite pattern to deal with
 * API responses in a general fashion.
 * 
 * @author Team Mercury
 */
public class ArrayComponent extends ResponseComponent implements Iterable<ResponseComponent>
{
   private List<ResponseComponent> theArray;
   
   protected ArrayComponent()
   {
      this.theArray = new ArrayList<ResponseComponent>();
   }
   
   protected void add(ResponseComponent comp)
   {
      theArray.add(comp);
   }
   
   /**
    * @param index
    * @return the component at index of the Array
    */
   public ResponseComponent get(int index)
   {
      return theArray.get(index);
   }
   
   public Iterator<ResponseComponent> iterator()
   {
      return theArray.iterator();
   }
}
