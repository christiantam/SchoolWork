import java.util.Iterator;
/**
 *  @author Lewis and Chase
 *
 *  Represents a linked implementation of a stack.
 */

public class LinkedStack<T> implements StackADT<T>
{
  /** indicates number of elements stored */
  private int count;  
  /** pointer to top of stack */
  private LinearNode<T> top; 

  /**
   * Creates an empty stack.
   */
  public LinkedStack()
  {
    count = 0;
    top = null;
  }


  /**
   * Adds the specified element to the top of this stack.
   * @param element element to be pushed on stack
   */
  public void push (T element)
  {
    LinearNode<T> temp = new LinearNode<T> (element);

    temp.setNext(top);
    top = temp;
    count++;
  }

  /**
   * Removes the element at the top of this stack and returns a
   * reference to it. Throws an EmptyCollectionException if the stack
   * is empty.
   * @return T element from top of stack
   * @throws EmptyCollectionException on pop from empty stack
   */
  public T pop(){
    if (isEmpty())
        throw new EmptyCollectionException("Stack");

      T result = top.getElement();
      top = top.getNext();
      count--;
   
      return result;
  }
   
  /**
   * Returns a reference to the element at the top of this stack.
   * The element is not removed from the stack.  Throws an
   * EmptyCollectionException if the stack is empty.
   * @return T element on top of stack
   * @throws EmptyCollectionException on peek at empty stack  
   */
  public T peek()  {
    if (isEmpty())
      throw new EmptyCollectionException("Stack"); 

    return top.getElement();
  }

  /**
   * Returns true if this stack is empty and false otherwise. 
   * @return boolean true if stack is empty
   */
  public boolean isEmpty()
  {
    return count == 0;
  }
 
  /**
   * Returns the number of elements in this stack.
   * @return int number of elements in this stack
   */
  public int size()
  {
    return count;
  }

  /**
   * Returns a string representation of this stack. 
   * @return String representation of this stack
   */
  public String toString()
  {
	  LinearNode<T> temp = top;
	  String output = "";
	  for(int i = 0; i < count; i++){
		  output += temp.getElement() + "\n";
		  temp = temp.getNext();
	  }
	  return output;
  }   
  
  public Iterator<T> iterator()
  {
     return new LinkedIterator<T> (top, count);
  }
  
  //--------------------------------------------------------------------
  // Test harness for Linked Stack
  //--------------------------------------------------------------------
  public static void main(String[] args)
  {
    LinkedStack<String> stack = new LinkedStack<String>();
    String onTop;

    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");

    // test size and toString
    //System.out.println("stack contains "+ stack.size() + " items: \n" + stack.toString());

   
    //test iterator
    Iterator<String> iter = stack.iterator();
    System.out.println(iter.hasNext());
    while(iter.hasNext()){
    	System.out.println(iter.next());
    }
 }
}
