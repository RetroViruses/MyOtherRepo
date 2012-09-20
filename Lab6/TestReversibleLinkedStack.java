public class TestReversibleLinkedStack {

	private static void reverseStack(ReversibleLinkedStack stack) {

		System.out.println("* Stack contents:\n");
		System.out.println(stack.toString());
	
		System.out.println("\n* Reversing stack");
		stack.reverse();

		System.out.println("* Stack contents:\n");
		System.out.println(stack.toString());
	}

	private static void testStackOfIntegers() {
		ReversibleLinkedStack<Integer> stack = new ReversibleLinkedStack<Integer>();

		System.out.println("* Adding the integers 1 - 10 to the stack");

		for (int i = 1; i <= 10; i++)
			stack.push(i);

		reverseStack(stack);	
	}

	private static void testStackOfCharacters() {

		ReversibleLinkedStack<Character> stack = new ReversibleLinkedStack<Character>();

		System.out.println("* Adding the letters 'A' - 'D' to the stack");

		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');

		reverseStack(stack);
	}
	
	private static void testStackOfStrings(){
		ReversibleLinkedStack<String> stack = new ReversibleLinkedStack<String>();

		System.out.println("* Adding the string 'Hello how are you?' to the stack");

		stack.push("Hello");
		stack.push("how");
		stack.push("are");
		stack.push("you?");

		reverseStack(stack);
	}

	public static void main(String[] args) {

		testStackOfIntegers();
		testStackOfCharacters();
		testStackOfStrings();

	}

}
