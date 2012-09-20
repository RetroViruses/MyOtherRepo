import java.io.*;

public class ExceptionExample11 {

   public static void main (String[] args) throws Exception {

      /* 
         - this handles the NumberFormatException

      */
	  boolean loopBool=false;
	  int value=0;
	  while (loopBool==false){
      BufferedReader keyboard=
         new BufferedReader (new InputStreamReader(System.in),1);

      System.out.print("Enter an integer: ");
      String userTyped = keyboard.readLine();

      try {
         value = Integer.parseInt(userTyped);
         loopBool=true;
      }
      catch (NumberFormatException e) {
         System.out.println("Hey, " + e.getMessage() + " is not an integer!");
         value=0;
      }
      }
   }
}