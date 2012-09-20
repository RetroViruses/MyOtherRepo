import java.io.*;
import java.util.Iterator;
/**
 * PhoneTest.java:
 * This class creates an Ordered List of Phone objects.
 * @author CS1027 for Lab
 */

public class PhoneTest {

  public static void main(String[] args) throws Exception {

	  
	ArrayOrderedList<Phone> phoneList=new ArrayOrderedList<Phone>();
    final String[] NAMES = {
                              "Charles", 
                              "Alice",
                              "Deb", 
                              "Bob"                                       
                           };
    
    final String[] NUMBERS = {
                               "222-222-2222",   // Charles' phone number
                               "444-444-4444",   // Alice's phone number
                               "333-333-3333",   // Deb's phone number
                               "111-111-1111"    // Bob's phone number
                             };


    // Add your code here
    for (int i=0;i<NAMES.length;i++){
    	Phone tempPhone=new Phone((NAMES)[i], NUMBERS[i]);
    	phoneList.add(tempPhone);
    }
           
    System.out.println("Here is my phone book:");

    //System.out.println(phoneList);
    /*
    Iterator<Phone> iter = phoneList.iterator();
    while( iter.hasNext() ) {
    System.out.println( iter.next() );
    }
    */
    System.out.println(phoneList.toString2());

  }
     
}
