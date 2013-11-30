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
