
public class WordReverser1 {

	public static void main(String[] args) {
		
		String word = "hello";
		
		for (int i = word.length() - 1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
		
		
	}
}
