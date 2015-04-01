//********************************************************************
//  IndexedListADT.java       Authors: Lewis/Chase
//
//  Defines the interface to an indexed list collection. Elements
//  are referenced by contiguous numeric indexes.
//********************************************************************

public interface IndexedListADT<T> extends ListADT<T>
{
   //  Inserts the specified element at the specified index
   public void add (int index, T element);

   //  Sets the element at the specified index
   public void set (int index, T element);

   //  Adds the specified element to the rear of this list
   public void add (T element);

   //  Returns a reference to the element at the specified index
   public T get (int index);

   //  Returns the index of the specified element
   public int indexOf (T element);

   //  Returns and returns the element at the specified index
   public T remove (int index);
}