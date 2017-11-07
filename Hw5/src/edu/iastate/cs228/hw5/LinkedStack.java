package edu.iastate.cs228.hw5;

import java.util.NoSuchElementException;

/**
* A stack is a special list of elements in which
* elements are added and removed at one end.
* A stack interface with common stack operations:
**/

interface PureStack<E>
{
  int size();
  boolean isEmpty();

// Adds an element to the top.
  void push(E element);

// Removes and returns the top element.
   E pop();

// Returns the top element without removing it.
   E peek();
}

/**
*
* A simple class that implements the PureStack interface with linked nodes.
* Each method of the class takes O(1) time.
* @author unknown
*
**/
public class LinkedStack<E> implements PureStack<E>
{
 /**
  * private class that represent now data is stack
  * @author unknown
  *
  */
  private class SNode
  {
    public E data;
    public SNode link;
  }

  private SNode top;    // refers to the top node of the stack.
  private int numItems; // number of elements in the stack.
  /**
   * Constructor
   */
  public LinkedStack()
  {
    top = null;
    numItems = 0;
  }
  /**
  * Determined the size of this stacj
  * @return the size of this stack
  */
  public int size()
  {
    return numItems;
  }
  /**
   * Determined either this stack is empty or not
   * @return true of empty, false otherwise
   */
  public boolean isEmpty()
  {
     return numItems == 0;
  }
  /**
   * Adds an element to the top.
   * @param element need to be added 
   */
  public void push(E element)
  {
    SNode toAdd = new SNode();
    toAdd.data = element;
    toAdd.link = top;
    top = toAdd;
    numItems++;
  }
  /**
   * Returns the top element and removing it.
   * @return top element
   */
  public E pop()
  {
    if ( top == null )
      throw new NoSuchElementException();
    E returnVal = top.data;
    top = top.link;
    if ( numItems <= 0 )
      throw new RuntimeException("An incorrect number of elements");
    numItems--;
    return returnVal;
  }
/**
 * Returns the top element without removing it.
 * @return top element
 */
  public E peek()
  {
    if ( top == null )
      throw new NoSuchElementException();
    return top.data;
  }
} // LinkedStack
