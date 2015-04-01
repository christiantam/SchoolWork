/**
 * @author Lewis and Chase
 *
 *  Represents the situation in which a collection is empty.
 *  HAHAHAHAHAHAHAHHAHA ITS COMMENTED ALREADY YAYYYYYYYYYYYYYYY
 */

public class EmptyCollectionException extends RuntimeException
{
  /**
   * Sets up this exception with an appropriate message.
   * @param collection String representing the name of the collection
   */
  public EmptyCollectionException (String collection)
  {
	  //DAM RIGHT IT'S EMPTY
	  super ("The " + collection + " is empty.");
  }
}