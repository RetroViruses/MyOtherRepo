
			/**
			 *  @author Lewis and Chase
			 *
			 *  Represents an array implementation of a stack.
			 */

			public class ArrayReverseStack<T> implements ReverseArrayADT<T>
			{
			  /**
			   * constant to represent the default capacity of the array
			   */
			  private final int DEFAULT_CAPACITY = 100;

			  /**
			   * int that represents both the number of elements and the next
			   * available position in the array
			   */
			  private int top;  

			  /**
			   * array of generic elements to represent the stack
			   */
			  private T[] stack;
			  
			  /**
			   * Creates an empty stack using the default capacity.
			   */
			  public ArrayReverseStack()
			  {

			    top = 0;
			    stack = (T[])(new Object[DEFAULT_CAPACITY]);
			  }

			  /**
			   * Creates an empty stack using the specified capacity.
			   * @param initialCapacity represents the specified capacity 
			   */
			  public ArrayReverseStack (int initialCapacity)
			  {

			    top = 0;
			    stack = (T[])(new Object[initialCapacity]);
			  }

			  /**
			   * Adds the specified element to the top of this stack, expanding
			   * the capacity of the stack array if necessary.
			   * @param element generic element to be pushed onto stack
			   */
			  public void insert (T element)
			  {
			    if (size() == stack.length) 
			      expandCapacity();
			    for (int x=top+1; x>=1;x--){
			    	stack[x] = stack[x-1];
			  }
			    stack[0]=element;
			    top++;
			  }

			  /**
			   * Removes the element at the top of this stack and returns a
			   * reference to it. Throws an EmptyCollectionException if the stack
			   * is empty.
			   * @return T element removed from top of stack
			   * @throws EmptyCollectionException if a pop is attempted on empty stack
			   */
				public T remove() throws EmptyCollectionException{
					if (isEmpty())
						throw new EmptyCollectionException("Stack");
					T result=stack[0];
					for (int x=0; x<top;x++){
						stack[x]=stack[x+1];
					}

					stack[top]=null;
					top--;
					return result;
				}
			  /**
			   * Returns a reference to the element at the top of this stack.
			   * The element is not removed from the stack.  Throws an
			   * EmptyCollectionException if the stack is empty.  
			   * @return T element on top of stack
			   * @throws EmptyCollectionException if a peek is attempted on empty stack
			   */
			  public T examine() throws EmptyCollectionException
			  {
			    if (isEmpty())
			      throw new EmptyCollectionException("Stack");

			    return stack[top-1];
			  }
			  /**
			   * Returns true if this stack is empty and false otherwise. 
			   * @return boolean true if this stack is empty, false otherwise
			   */
			  public boolean isEmpty()
			  {
			    return (top == 0);
			  }
			 
			  /**
			   * Returns the number of elements in this stack.
			   * @return int the number of elements in this stack
			   */
			  public int size()
			  {
			    return top;
			  }

			  /**
			   * Returns a string representation of this stack. 
			   * @return String representation of this stack
			   */
			  public String toString()
			  {
			    String result = "";

			    for (int scan=0; scan < top; scan++)
			      result = result + stack[scan].toString() + "\n";

			    return result;
			    
			    
			    
			  }

			  /**
			   * Creates a new array to store the contents of this stack with
			   * twice the capacity of the old one.
			   */
			  private void expandCapacity()
			  {
			    T[] larger = (T[])(new Object[stack.length*2]);
			    
			    for (int index=0; index < stack.length; index++)
			      larger[index] = stack[index];
			    
			    stack = larger;
			  }
			}
