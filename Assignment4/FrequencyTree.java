
import java.util.Iterator;

/**
 * A FrequencyTree is a binary search tree that does not allow duplicates.
 * When and object of type T is inserted, a CountedItem<T> object containing
 * the data item and its corresponding frequency is inserted into the tree.
 * If an attempt is made to reinsert the same object, the frequency counter
 * in the existing node is incremented, and no new node is added to the tree.
 * 
 * FrequencyTrees can be stored efficiently in text files, and reconstructed
 * efficiently from files.
 *
 * @param <T> The class of objects being stored in the tree
 */
public class FrequencyTree<T> implements FrequencyTreeADT<T>

{

	private int count;			/* The number of nodes in the tree */
	public CountedItem<T> defCount = new CountedItem<T>((T)"default");

	private BinaryTreeNode<CountedItem<T>> root; /* reference to the root node */
	private BinaryTreeNode<CountedItem<T>> tempRoot = root;
	private BinaryTreeNode<CountedItem<T>> tempRoot2=root;
	public int stringLoca=0;
	/*
	 * Constructor creates an empty FrequencyTree
	 */
	public FrequencyTree()
	{
		root=new BinaryTreeNode<CountedItem<T>>(defCount);
	}


	/**
	 * 
	 * @return True if the tree is empty, and false otherwise
	 */	
	public boolean isEmpty()
	{
		return count==0;
	}



	/**
	 * @return The number of elements in the FrequencyTree
	 */
	public int size()
	{
		return count;
	}





	/**
	 * Add a CountedItem containing the object element to the FrequencyTree
	 * @param element The data object to be added to the FrequencyTree
	 */
	public void addElement(T element)
	{
		/* Use a recursive algorithm modelled on the one given on
	   slide 11-11 of the lecture notes. You may need to use a
         private helper method for the recursion */

		BinaryTreeNode<CountedItem<T>> changer = root;
		BinaryTreeNode<CountedItem<T>> newNode=root;
		CountedItem<T> setCount = new CountedItem<T>(element);
		int y=0;

		try{
			CountedItem<T> newElem = (CountedItem<T>)(element);
			changer = findAdd((T)defCount, root);
			changer.setElement(newElem);
		}
		catch(ClassCastException e){
			while (y<1)
				try{
					if (changer.getRight().getElement()!=null){
						changer=changer.getRight();
					}
					else{
						changer.setElement(setCount);
						y=y+5;
					}
				}
			catch(NullPointerException v){
				changer.setElement(setCount);
				y=y+5;
			}
		}

	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.  Throws a NoSuchElementException if
	 * the specified target element is not found in the binary tree.
	 *
	 * @param targetElement              the element being sought in this tree
	 * @return                           a reference to the specified target
	 * @throws ElementNotFoundException  if an element not found exception occurs
	 */
	public T find(T targetElement) throws ElementNotFoundException
	{
		BinaryTreeNode<CountedItem<T>> current = findAgain( targetElement, root );

		if( current == null )
			throw new ElementNotFoundException("binary tree");

		return ((T)current.getElement());
	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.
	 *
	 * @param targetElement  the element being sought in this tree
	 * @param next           the element to begin searching from
	 */
	private BinaryTreeNode<CountedItem<T>> findAgain(T targetElement, 
			BinaryTreeNode<CountedItem<T>> next)
			{
		if (next == null)
			return null;

		if (next.getElement().equals(targetElement))
			return next;

		BinaryTreeNode<CountedItem<T>> temp = findAgain(targetElement, next.getLeft());

		if (temp == null)
			temp = findAgain(targetElement, next.getRight());

		return temp;
			}

	/**
	 * @param targetElement The object being sought in the FrequencyTree
	 * @return A reference to the element, once it is found; if it is
	 * not in the FrequencyTree, an exception is thrown
	 */
	public CountedItem<T> findAgain(CountedItem<T> targetElement) throws ElementNotFoundException
	{
		BinaryTreeNode<CountedItem<T>> current = tempRoot;
		if (current.getElement()==targetElement){
			return current.getElement();
		}
		if (tempRoot.getLeft() != null){
			tempRoot = tempRoot.getLeft();
			findAgain(targetElement);
		}
		else if (tempRoot.getRight() != null){
			tempRoot= tempRoot.getRight();
			findAgain(targetElement);
		}
		if( current == null ){
			throw new ElementNotFoundException("binary tree");
		}

		return (current.getElement());
	}

	/**
	 * searches for the element, starting at node next
	 * @param targetElement the element to search for
	 * @param next the node to start searching from
	 * @return the found element (or null, if not found)
	 */
	private BinaryTreeNode<CountedItem<T>> findAdd(T targetElement, BinaryTreeNode<CountedItem<T>> next)
	{
		if (next == null)
			return next;

		if (next.getElement().equals(targetElement))
			return next;

		BinaryTreeNode<CountedItem<T>> temp = findAgain(targetElement, next.getLeft());

		if (temp == null)
			temp = findAgain(targetElement, next.getRight());

		return temp;
	}


	/**
	 * @param targetElement The object being sought in the FrequencyTree
	 * @return True if targetElement is in the FrequencyTree, and 
	 * false otherwise
	 */
	public boolean contains(T targetElement)
	{
		BinaryTreeNode<CountedItem<T>> current = findAgain( targetElement, root );

		if( current == null ){
			return false;
		}
		else{
			return true;
		}
	}




	/**
	 * 
	 * @return A string representing the contents of the FrequencyTree,
	 * using an inorder traversal
	 */
	public String toStringInOrder()
	{
		String storeString="";
		Iterator<T> iter = iteratorInOrder();
		while (iter.hasNext()){
			storeString=storeString+iter.next()+"\n";
		}
		return storeString;
	}

	/**
	 * 
	 * @return A string representing the contents of the FrequencyTree,
	 * using a preorder traversal
	 */
	public String toStringPreOrder()
	{
		String storeString="";
		Iterator<T> iter = iteratorPreOrder();
		while (iter.hasNext()){
			storeString=storeString+iter.next()+"\n";
		}
		return storeString;
	}

	/**
	 * @return A string representation of the FrequencyTree
	 */
	public String toString()
	{
		return "Finally, nothing to see here";
	}


	/**
	 * 
	 * @return An iterator over the elements of a tree created using an
	 * inorder traversal
	 */
	public Iterator<T> iteratorInOrder()
	{
		/* Use a private recursive method inorder() in your solution */
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inorder (root, tempList);

		return tempList.iterator();
	}

	/**
	 * An inorder iterator helper method
	 * @param node
	 * @param tempList
	 */
	private void inorder (BinaryTreeNode<CountedItem<T>> node, ArrayUnorderedList<T> tempList) 
	{
		if (node != null)
		{
			inorder (node.getLeft(), tempList);
			tempList.addToRear((T)node.getElement());
			inorder (node.getRight(), tempList);

		}
	}  



	/**
	 * 
	 * @return An iterator over the elements of a tree created using a 
	 * preorder traversal
	 */
	public Iterator<T> iteratorPreOrder()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preorder (root, tempList);

		return tempList.iterator();
	}

	/**
	 * A preorder iterator helper method
	 * @param node
	 * @param tempList
	 */
	private void preorder (BinaryTreeNode<CountedItem<T>> node, ArrayUnorderedList<T> tempList) 
	{
		if (node != null)
		{
			tempList.addToRear((T)node.getElement());
			preorder (node.getLeft(), tempList);
			preorder (node.getRight(), tempList);
		}
	}  



	/**
	 * 
	 * @return An iterator over the elements of a tree created using a
	 * postorder traversal
	 */
	public Iterator<T> iteratorPostOrder()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		postorder (root, tempList);

		return tempList.iterator(); 
	}

	/**
	 * A postorder iterator helper method
	 * @param node
	 * @param tempList
	 */
	private void postorder (BinaryTreeNode<CountedItem<T>> node, ArrayUnorderedList<T> tempList) 
	{
		if (node != null)
		{
			postorder (node.getLeft(), tempList);
			postorder (node.getRight(), tempList);
			tempList.addToRear(node.getElement().getData());
		}
	}  



	/**
	 * 
	 * @return An iterator over the elements of a tree created using a
	 * levelorder traversal
	 */
	public Iterator<T> iteratorLevelOrder()
	{

		/* Use a LinkedQueue in the algorithm from slides 10-30 through
         10-33 of the lecture notes */
		ArrayUnorderedList<T> temp = new ArrayUnorderedList<T>();
		LinkedQueue<BinaryTreeNode<CountedItem<T>>> nodes = new LinkedQueue<BinaryTreeNode<CountedItem<T>>>();
		BinaryTreeNode<T> tempRoot=new BinaryTreeNode<T>(root.getElement().getData());
		nodes.enqueue((BinaryTreeNode<CountedItem<T>>)root);
		while (!nodes.isEmpty()){
			tempRoot = (BinaryTreeNode<T>)nodes.dequeue();
			if (tempRoot != null){
				temp.addToRear(((CountedItem<T>) tempRoot.getElement()).getData());
				temp.addToRear(((CountedItem<T>) tempRoot.getLeft().getElement()).getData());
				temp.addToRear(((CountedItem<T>) tempRoot.getRight().getElement()).getData());
			}
		}
		return temp.iterator();
	}



	/**
	 * 
	 * @return An iterator over the nodes of a tree created using an
	 * inorder traversal
	 */
	private Iterator<T> nodeInOrderIterator()
	{

		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inorder (root, tempList);

		return tempList.iterator();
	}



	/**
	 * 
	 * @return An iterator over the nodes of a tree created using a 
	 * preorder traversal
	 */
	private Iterator<BinaryTreeNode<CountedItem<T>>> nodePreOrderIterator()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preorder (root, tempList);

		return (Iterator<BinaryTreeNode<CountedItem<T>>>) tempList.iterator();
	}





	/**
	 * 
	 * @return An iterator over the nodes of a tree created using a
	 * postorder traversal
	 */
	private Iterator<BinaryTreeNode<CountedItem<T>>> nodePostOrderIterator()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		postorder (root, tempList);

		return (Iterator<BinaryTreeNode<CountedItem<T>>>) tempList.iterator(); 
	}



	/**
	 * 
	 * @return An iterator over the nodes of a tree created using a
	 * levelorder traversal
	 */
	private Iterator<BinaryTreeNode<CountedItem<T>>> nodeLevelOrderIterator()
	{
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inorder (root, tempList);

		return (Iterator<BinaryTreeNode<CountedItem<T>>>) tempList.iterator();
	}  



	/**
	 * 
	 * @return A string of zeroes and ones that represents the current
	 * shape of the binary tree; the string uses a preorder representation
	 */
	public String getShape()
	{
		BinaryTreeNode<CountedItem<T>> newRoot=root;
		BinaryTreeNode<CountedItem<T>> newRoot2=root;
		String store = "";
		for (int i=0; i<count;i++){
			if (newRoot.getLeft()!=null && newRoot.getRight()!=null){
				store=store+"11";
				newRoot=newRoot.getLeft();
			}
			else if (newRoot.getLeft()!=null && newRoot.getRight()==null){
				store=store+"10";
				newRoot=newRoot.getLeft();
			}
			else if (newRoot.getLeft()==null && newRoot.getRight()!=null){
				store=store+"01";
				newRoot=newRoot.getRight();
			}
			else if (newRoot.getLeft()==null && newRoot.getRight()==null){
				store=store+"00";
				newRoot=root.getRight();
			}
		}
		return store;
	}


	/**
	 * Build a FrequencyTree in the shape described by a string of zeroes 
	 * and ones. No data elements are put into the nodes of the tree by
	 * this method.
	 * @param shapeDescriptor A string of zeroes and ones describing the
	 * shape of the tree to be built
	 */
	public void buildTree(String shapeDescriptor)
	{
		/* Use a recursive private method to create the tree. Remember
             to increment the tree size appropriately as you build it.
             You may find it useful to have an instance variable that keeps
             track of your position in the shapeDescriptor string */
		//buildTreeHelper(shapeDescriptor, root);
		String tempShape=shapeDescriptor.substring(shapeDescriptor.length()-2);
		if (tempShape!="00"){
			shapeDescriptor=shapeDescriptor.substring(0, shapeDescriptor.length()-2)+"00";
		}
		root=buildTreeHelper2(shapeDescriptor);
	}

	/**
	 * a helper method for buildTree
	 * @param shapeDes same purpose as shapeDescriptor
	 * @return the node to build onto
	 */
	private BinaryTreeNode<CountedItem<T>> buildTreeHelper2(String shapeDes){
		BinaryTreeNode<CountedItem<T>> newBuild = new BinaryTreeNode<CountedItem<T>>(defCount);
		count=count+1;
		String tempString="";
		String tempString2="11";
		tempString=shapeDes.substring(stringLoca, stringLoca+2);
		stringLoca=stringLoca+2;
		int compare=tempString.compareTo(tempString2);
		if (compare==0){
			newBuild.setLeft(buildTreeHelper2(shapeDes));
			newBuild.setRight(buildTreeHelper2(shapeDes));
		}
		tempString2="10";
		compare=tempString.compareTo(tempString2);
		if (compare==0){
			newBuild.setLeft(buildTreeHelper2(shapeDes));
		}
		tempString2="01";
		compare=tempString.compareTo(tempString2);
		if (compare==0){
			newBuild.setRight(buildTreeHelper2(shapeDes));
		}
		return newBuild;
	}



	/**
	 * Use a preorder traversal to fill in the contents of a FrequencyTree.
	 * Each element is a CountedItem, made up of an object from class T and
	 * its corresponding frequency.
	 * @param data An array of the data values to be stored
	 * @param frequencies A parallel array of the frequency counts for the
	 * data values
	 */
	public void fillTree(T[] data, int[] frequencies)
	{
		int x=0;
		while (x<count){
			//if (contains(data[x])){
			CountedItem<T> newCount = new CountedItem<T>(data[x], frequencies[x]);
			addElement((T)newCount);
			x++;
			// }
		}
	}



	/**
	 * Write the current size, shape and contents of the FrequencyTree
	 * to an output file
	 */
	public void writeTreeToFile(OutputFileHandler file)
	{
		file.writeLine(Integer.toString(count));
		file.writeLine(getShape());
		Iterator<CountedItem<T>> scan = (Iterator<CountedItem<T>>)iteratorPreOrder();
		while (scan.hasNext()) {
			CountedItem<T> item = scan.next();
			file.writeLine(item.getData().toString());
			file.writeLine(Integer.toString(item.getFrequency()));
		}
		stringLoca=0;
		count=0;
	}
}

