
import java.util.Iterator;
/**
 *  @author Lewis and Chase
 *
 *  Represents a linked implementation of a stack.
 */

public class LinkedStack<T> implements StackADT<T>
{
  /** indicates number of elements stored */
  protected int count;  
  /** pointer to top of stack */
  protected LinearNode<T> top; 

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
  public T pop() throws EmptyCollectionException
  {
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
  public T peek() throws EmptyCollectionException
  {
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
	  return (count == 0);
  }
 
  /**
   * Returns the number of elements in this stack.
   * @return int number of elements in this stack
   */
  public int size()
  {
	  return count;
  }

  public void changeSize(int tempCount){
	count = tempCount;
  }
  
  public LinearNode<T> getTop(){
	  return top;
  }
  
  public void setTop(LinearNode<T> newTop){
	  top=newTop;
  }
  
  /**
   * Returns a string representation of this stack. 
   * @return String representation of this stack
   */
  public String toString()
  {
	    String result = "";
	    LinearNode<T> tempTop=top; 
	    for (int scan=0; scan < count; scan++){
	      result = result + tempTop.getElement() + "\n";
	      tempTop = tempTop.getNext();
	    }
	    return result;
  }
  public static void main(String[] args){
	  ArrayOrderedList<Phone> phoneList=new ArrayOrderedList<Phone>();
	    final String[] NAMES = {
	                              "Charles", 
	                              "Alice",
	                              "Deb", 
	                              "Bob"                                       
	                           };
	    
	    final String[] NUMBERS = {
	                               "222-222-2222",   // Charles' phone number
	                               "444-444-4444",   // Alice's phone number
	                               "333-333-3333",   // Deb's phone number
	                               "111-111-1111"    // Bob's phone number
	                             };


	    // Add your code here
	    LinkedStack a = new LinkedStack();
	    Phone temp;
	    for (int i=0;i<NAMES.length;i++){
	    	temp = new Phone((NAMES)[i], NUMBERS[i]);
	    	a.push(temp);
	    }
	           
	    System.out.println("Here is my phone book:");

	    System.out.println(a);

	    }
	    
  
  }


