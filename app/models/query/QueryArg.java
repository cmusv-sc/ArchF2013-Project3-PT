package models.query;

/**
 * Currently all the Query*Args are wrappers around string
 * This superclass provides a common place for that functionality
 * @author geoffschaeffer
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
