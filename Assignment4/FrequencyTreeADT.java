import java.util.Iterator;


public interface FrequencyTreeADT<T>
{
	/**
	 * 
	 * @return True if the tree is empty, and false otherwise
	 */
	 public boolean isEmpty();

	
	 /**
	  * @return The number of elements in the FrequencyTree
	  */
	 public int size();

	   //  Should be implemented to return true if the binary tree
	   //  contains an element that matches the specified element and
	   //  false otherwise.
	 
	 /**
	  * @param targetElement The object being sought in the FrequencyTree
	  * @return True if targetElement is in the FrequencyTree, and 
	  * false otherwise
	  */
	 public boolean contains (T targetElement);


	   
	   /**
	    * @param targetElement The object being sought in the FrequencyTree
	    * @return A reference to the element, once it is found; if it is
	    * not in the FrequencyTree, an exception is thrown
	    */
	   public T find (T targetElement);


	   
	   /**
	    * @return A string representation of the FrequencyTree
	    */
	   public String toString();


	   /**
	    * @return An iterator that visits tree nodes in inorder fashion
	    */
	   public Iterator<T> iteratorInOrder();


	   /*
	    * @return An iterator that visits tree nodes in preorder fashion
	    */
	   public Iterator<T> iteratorPreOrder();


	   /**
	    *  @return An iterator that visits tree nodes in postorder fashion
	    */
	   public Iterator<T> iteratorPostOrder();


	   /**
	    * @return An iterator that visits tree nodes in levelorder fashion
	    */
	   public Iterator<T> iteratorLevelOrder();

	   
	   /**
	    * Add a CountedItem containing the object element to the FrequencyTree
	    * @param element The data object to be added to the FrequencyTree
	    */
	   public void addElement (T element);
	   
	   

	    /**
	     * 
	     * @return A string representing the contents of the FrequencyTree,
	     * using an inorder traversal
	     */
	    public String toStringInOrder();
	    
	    
	    /**
	     * 
	     * @return A string representing the contents of the FrequencyTree,
	     * using a preorder traversal
	     */
	    public String toStringPreOrder();
	    
	    
		/**
		 * 
		 * @return A string of zeroes and ones that represents the current
		 * shape of the binary tree; the string uses a preorder representation
		 */
		public String getShape();
		
		
		/**
		 * Build a FrequencyTree in the shape described by a string of zeroes 
		 * and ones. No data elements are put into the nodes of the tree by
		 * this method.
		 * @param shapeDescriptor A string of zeroes and ones describing the
		 * shape of the tree to be built
		 */
		public void buildTree(String shapeDescriptor);
		
		
		/**
		 * Use a preorder traversal to fill in the contents of a FrequencyTree.
		 * Each element is a CountedItem, made up of an object from class T and
		 * its corresponding frequency.
		 * @param data An array of the data values to be stored
		 * @param frequencies A parallel array of the frequency counts for the
		 * data values
		 */
		public void fillTree(T[] data, int[] frequencies);
		
		
		

	
}