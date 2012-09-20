
public class DemoReverseStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayReverseStack<Integer> rStack = new ArrayReverseStack<Integer>();
		
		rStack.insert(new Integer(5));
		rStack.insert(new Integer(4));
		rStack.insert(new Integer(3));
		rStack.insert(new Integer(2));
		rStack.insert(new Integer(1));

		System.out.println("Current Stack: \n" + rStack + "\n");
		System.out.println("Current top of Stack: " + rStack.examine() + "\n");

		// use debug methods to determine why this does not print out the 
		// entire stack
		ArrayReverseStack<Integer> tempStack = new ArrayReverseStack<Integer>();
		tempStack.insert(new Integer(5));
		tempStack.insert(new Integer(4));
		tempStack.insert(new Integer(3));
		tempStack.insert(new Integer(2));
		tempStack.insert(new Integer(1));
		for (int i = 1; i <= tempStack.size(); i++)
		{
			System.out.println(rStack.remove().toString());
		}


	}

}
