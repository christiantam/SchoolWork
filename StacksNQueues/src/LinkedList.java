/**
 * LinkedList represents a linked implementation of a list.
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */

import java.util.*;

public class LinkedList<T> implements ListADT<T>, Iterable<T>
{
   protected int count;
   protected LinearNode<T> head, tail;
   
   /**
    * Creates an empty list.
    */
   public LinkedList()
   {
      count = 0;
      head = tail = null;
   }
   
   /**
    * Removes the first element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           a reference to the first element of 
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T removeFirst() throws EmptyCollectionException
   {
       //left as programming project
	   LinearNode<T> temp = head;
	   head = head.getNext();
	   count--;
	   return temp.getElement();
	   
   }
   
   /**
    * Removes the last element in this list and returns a reference
    * to it.  Throws an EmptyListException if the list is empty.
    *
    * @return                           the last element in this list
    * @throws EmptyCollectionException  if an empty collection exception occurs    
    */
   public T removeLast() throws EmptyCollectionException
   {
       //left as programming project
	   if(count == 0)
		   throw new EmptyCollectionException("empty");
	   LinearNode<T> temp = head;
	   for(int i = 1; i < count; i++){
		   temp.getNext();
	   }
	   temp.setNext(null);
	   count--;
	   LinearNode<T> temp2 = tail;
	   tail = temp;
	   return temp2.getElement();
   }
   
   /**
    * Removes the first instance of the specified element from this
    * list and returns a reference to it.  Throws an EmptyListException 
    * if the list is empty.  Throws a NoSuchElementException if the 
    * specified element is not found in the list.
    *
    * @param targetElement              the element to be removed from the list
    * @return                           a reference to the removed element
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public T remove (T targetElement) throws EmptyCollectionException, 
         ElementNotFoundException 
   {
      if (isEmpty())
         throw new EmptyCollectionException ("List");
      
      boolean found = false;
      LinearNode<T> previous = null;
      LinearNode<T> current = head;
      
      while (current != null && !found)
         if (targetElement.equals (current.getElement()))
            found = true;
         else
         {
            previous = current;
            current = current.getNext();
         }
            
      if (!found)
         throw new ElementNotFoundException ("List");
      
      if (size() == 1)
         head = tail = null;
      else if (current.equals (head))
         head = current.getNext();
      else if (current.equals (tail))
      {
         tail = previous;
         tail.setNext(null);
      }
      else
         previous.setNext(current.getNext());
      
      count--;
      
      return current.getElement();
   }
   
   /**
    * Returns true if the specified element is found in this list and 
    * false otherwise.  Throws an EmptyListException if the specified
    * element is not found in the list.                                     
    *
    * @param targetElement              the element that is sought in the list
    * @return                           true if the element is found in 
    *                                   this list
    * @throws EmptyCollectionException  if an empty collection exception occurs
    */
   public boolean contains (T targetElement) throws EmptyCollectionException 
   {
       //left as programming project
	   int position = 0;
	   boolean found = false;
	   LinearNode<T> temp = head;
	   while(position < count && !found){
		   if(temp.getElement().equals(targetElement)){
			   found = true;
		   }
		   temp = temp.getNext();
	   }
	   return found;
   }
   
   /**
    * Returns true if this list is empty and false otherwise.
    *
    * @return  true if this list is empty
    */
   public boolean isEmpty()
   {
       //left as programming project
	   return(count == 0);
   }

   /**
    * Returns the number of elements in this list.
    *
    * @return  the integer representation of the number of elements in this list
    */
   public int size()
   {
       //left as programming project
	   return count;
   }

   /**
    * Returns a string representation of this list.
    *
    * @return  a string representation of this list    
    */
   public String toString()
   {
       //left as programming project
	   String output = "";
	   LinearNode<T> temp = head;
	   for(int i = 0; i < count; i++){
		   output += head.getElement() + "\n";
		   temp = temp.getNext();
	   }
	   return output;
   }

   /**
    * Returns an iterator for the elements currently in this list. 
    *
    * @return  an iterator over the elements of this list
    */
   public Iterator<T> iterator()
   {
      return new LinkedIterator<T>(head, count);
   }

   /**
    * Returns the first element in this list. 
    *
    * @return  the first element in this list
    */
   public T first()
   {
       //left as programming project
	   return head.getElement();
   }

   /**
    * Returns the last element in this list. 
    *
    * @return  the last element in this list    
    */
   public T last()
   {
       //left as programming project
	   return tail.getElement();
   }
}
