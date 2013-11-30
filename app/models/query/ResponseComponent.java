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
