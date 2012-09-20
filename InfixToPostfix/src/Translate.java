//import statements
import java.util.Scanner;

public class Translate {

  public static void main (String[] args) {
    String expression, again;
    String result;
    //declares var that stores the answer to the equation
    int finRes=0;
    //object used to translate the expression
    PostedInfixToPostfix translator = new PostedInfixToPostfix();
    
    try {
      Scanner in = new Scanner(System.in); 
      do {
        System.out.println ("Enter a valid infix expression: ");
        expression = in.nextLine();
        
        //declares variable so that the evaluater can be used
        PostfixEvaluator postEval = new PostfixEvaluator();
        result = translator.translate(expression);
        finRes = postEval.evaluate(result);
        System.out.println();
        System.out.println ("This expression in postfix: " + result);
        System.out.println ("Which results in "+finRes);
        System.out.print ("Translate another expression [Y/N]? ");
        again = in.nextLine();
        System.out.println();
      }
      while (again.equalsIgnoreCase("y"));
    }
    catch (Exception IOException) {
    		System.out.println("Input exception reported");
    }	
  }
}