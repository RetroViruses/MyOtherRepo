//import statements
import java.util.StringTokenizer;

public class PostedInfixToPostfix {

//declares the constant value for the strings of the
//add, subtract, multiply, divide, and the left and right brackets
  private final String ADD = "+";
  private final String SUBTRACT = "-";
  private final String MULTIPLY = "*";
  private final String DIVIDE = "/";
  private final String LEFTB = "(";
  private final String RIGHTB = ")";
  
//declares constants for the priority given to the addition/subtraction
//and the multiplication/division (note that multiplication/division has higher priority)
  private final int ADD_PREC = 2;
  private final int MUL_PREC = 4;
  
//gives the stack string which is used to store the operators
  private ArrayStack<String> stack;
  
//stores the number of open left brackets at any point in the program
  private int brackNum=0;
  
//stores the number of operators used in that set of brackets
  private int symNum=0;
  
/**
 * constructor that assigns a array of strings to the variable stack
 */
  public PostedInfixToPostfix() {
    stack = new ArrayStack<String>();
  }
  
  /**
   * translates the string given from an infix to the postfix format
   * @param expr the infix format expression given to the method to be translated
   * @return the returned, postfix translated string
   */
  public String translate (String expr) {

	//declares two strings, to be used in storing the current token in the given
	//infix expression, and the postfix string to be outputted
    String token, outputString = "" ;
    //tokenizes one of the tokens from the infix expression
    StringTokenizer tokenizer = new StringTokenizer (expr);
    //adds precedence to operators with brackets
    int precTo = 0;
    
    //As long as the infix has more tokens, it'll continue adding more to be evaluated
    while (tokenizer.hasMoreTokens()) {
      token = tokenizer.nextToken();
      System.out.println("token is " + token) ;
      
      //records that a left bracket is added
      if (isLBrack(token)){
    	  brackNum=brackNum+1;
      }
      //records that a right bracket is added (by removing a left bracket from the counter)
      else if (isRBrack(token)){
    	  //loops based on the number of operators since the last left bracket, adding them to the string
    	  for (int i=0; i<symNum; i++){
        	  outputString += stack.pop()+ " ";
    	  }
    	  //reduces number of open brackets
    	  brackNum=brackNum-1;
    	  //resets the number of operators in the brackets
    	  symNum=0;
      }
      else if (!isOperator(token)) {
    	//if it is not an operator(as brackets were already taken care of), add it to the string
        outputString += token + " " ;
      }
      else {
    	  //increases symNum, as the remaining possible inputs are operators
    	  symNum=symNum+1;
    	  //if nothing else is in the stack, adds a token to the stack
        if (stack.isEmpty()) {
          stack.push(token) ;
        }
        else {
          //sets value of the precedence of the token
          precTo = precedence(token);
          //increases the precedence based on whether or not there is an excess of left brackets
          if (brackNum>0){
        	  precTo=precTo+(brackNum*3);
          }
          else{
        	  //if there is not left bracket excess, sets the precedence to a constant
        	  precTo=precedence(token);
          }
          if (precedence(stack.peek()) > precTo ) {
        	//outputs the operator to the string if the precedence of it is too low
            outputString += stack.pop() + " ";
          }
          stack.push(token) ;
        }
      }
    }
    while (!stack.isEmpty()) {
      //as long as the stack is not empty, adds to the string what remains
      outputString += stack.pop() + " " ;
    }
    //returns the string
    return outputString ;
  }
  
  /**
   * gives precedence to the token if it is multiplication or division
   * @param token the operator to be found if it is either add/subtract or multiply/divide
   * @return the value of the precedence for that operator
   */
  private int precedence(String token) {
      
    if (token.equals(ADD) || token.equals(SUBTRACT)) {
    	return ADD_PREC ;
    }
    else {
    	return MUL_PREC ;
    }
  }
  
/**
 * Returns whether the token is an operator
 * @param token the token to be judged as an operator or not
 * @return whether or not the token is an operator
 */
  private boolean isOperator (String token) {

    return (token.equals(ADD) || token.equals(SUBTRACT) || token.equals(MULTIPLY) || token.equals(DIVIDE));
  }
  
  /**
   * Returns whether the token is a left bracket
   * @param token the token to be judged as a left bracket or not
   * @return whether or not the token is a left bracket
   */
  private boolean isLBrack (String token) {
	 return (token.equals(LEFTB));
  }
  
  /**
   * Returns whether the token is a right bracket
   * @param token the token to be judged as a right bracket or not
   * @return whether or not the token is a right bracket
   */
  private boolean isRBrack (String token) {
		 return (token.equals(RIGHTB));
	  }
}