
public class DemoStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ArrayStack<Integer> aStack = new ArrayStack<Integer>();
		
		aStack.push(new Integer(5));
		aStack.push(new Integer(4));
		aStack.push(new Integer(3));
		aStack.push(new Integer(2));
		aStack.push(new Integer(1));

		System.out.println("Current Stack: \n" + aStack + "\n");
		System.out.println("Current top of Stack: " + aStack.peek() + "\n");

		for (int i = 1; i <= aStack.size(); i++)
		{
			System.out.println(aStack.pop().toString());
		}


	}


}
