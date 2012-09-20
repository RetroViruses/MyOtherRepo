
public class WordReverser2 {

	public static void main(String[] args) {
		
		String word = "hello";
		
		ArrayStack<Character> letters = new ArrayStack<Character>();
		
		for (int i = 0; i <= word.length()-1; i++) {
			letters.push(word.charAt(i));
		}
		
		while (!letters.isEmpty())
			System.out.print(letters.pop());		
	}
}
