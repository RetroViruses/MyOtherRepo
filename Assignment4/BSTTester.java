import java.util.Iterator;


public class BSTTester
{
	
	public static void main(String[] args)
	{
		LinkedBinarySearchTree<Integer> bst = new LinkedBinarySearchTree<Integer>();
		bst.addElement(new Integer(23));
		bst.addElement(new Integer (16));
		bst.addElement(new Integer(4));
		bst.addElement(new Integer(50));
		bst.addElement(new Integer(43));
		bst.addElement(new Integer(36));
		bst.addElement(new Integer(43));
		bst.addElement(new Integer(47));
		bst.addElement(new Integer(4));
		bst.addElement(new Integer(50));
		bst.addElement(new Integer(43));
		bst.addElement(new Integer(36));
		bst.addElement(new Integer(43));
		bst.addElement(new Integer(50));
		bst.addElement(new Integer(50));
		bst.addElement(new Integer(19));
		bst.addElement(new Integer(50));
		bst.addElement(new Integer(2));
		bst.addElement(new Integer(58));
		bst.addElement(new Integer(49));
		
		System.out.println("Output from toString():\n" + bst.toString());
		
		System.out.println("\n\nPreorder traversal:");
		Iterator<Integer> scan = bst.iteratorPreOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());
		
		System.out.println("\n\nInorder traversal:");
		scan = bst.iteratorInOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());

		
		System.out.println("\n\nPostorder traversal:");
		scan = bst.iteratorPostOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());
		
		
		System.out.println("\n\nLevelorder traversal:");
		scan = bst.iteratorLevelOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());

        bst.removeElement(new Integer(50));
        bst.removeElement(new Integer(23));
        bst.removeElement(new Integer(19));
        bst.removeElement(new Integer(50));
        bst.removeElement(new Integer(36));
		bst.removeAllOccurrences(new Integer(43));
		bst.removeAllOccurrences(new Integer(4));
		bst.removeAllOccurrences(new Integer(36));

		
		System.out.println("\n\nAfter deleting several nodes\nPreorder traversal:");
		scan = bst.iteratorPreOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());
		
		System.out.println("\n\nInorder traversal:");
		scan = bst.iteratorInOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());

		
		System.out.println("\n\nPostorder traversal:");
		scan = bst.iteratorPostOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());
		
		
		System.out.println("\n\nLevelorder traversal:");
		scan = bst.iteratorLevelOrder();
		while (scan.hasNext())
			System.out.println(scan.next().toString());

		 
	}
}