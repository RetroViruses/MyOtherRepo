import java.io.*;

public class RecursionLab{

	public static void reversePrint(String inString) {

		if (inString.length() > 0)  //if string is not empty
		{
			System.out.print(inString.charAt(inString.length()-1));
			reversePrint(inString.substring(0, inString.length()-1));
		}
	}

	public static String reverseString(String inString){
		String tempString;
		if (inString.length() == 0) {
			return "";
		}
		else{
			tempString=inString.substring(inString.length()-1,inString.length());
			inString=inString.substring(0,inString.length()-1);
			tempString=tempString.concat(reverseString(inString));
			return tempString;
		}
	}
	
	public static void main(String[] args) {
		String inString = "abcde";

		//test reversePrint
		reversePrint(inString);
		// test reverseString
		String revString = reverseString(inString);
		System.out.println(revString);
	}
}
