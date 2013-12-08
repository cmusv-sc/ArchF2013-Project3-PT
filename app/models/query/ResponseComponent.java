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
 * Abstract Superclass for ResponseComponents
 * Will be either an ArrayComponent, CompositeComponent, or ValueComponent
 * 
 * ResponseComponents use the Composite pattern to deal with
 * API responses in a general fashion.
 * 
 * ArrayComponent is an Array of components
 * CompositeComponent is a key->value of a tag to a Component
 * ValueComponent wraps a value in a component
 * 
 * In this fashion, any API response can be represented as a collection
 * of ResponseComponents.
 * (Ex: JSON, Object, XML...)
 * 
 * @author Team Mercury
 */
public abstract class ResponseComponent
{
}
