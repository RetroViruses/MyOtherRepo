/**
 * Sample application that uses the SocialNetwork class
 * @author CS1027
 *
 */

public class MyFriends {

	public static void main(String[] args){
		
		// create social network
		SocialNetwork contacts = new SocialNetwork();
		
		// add some friends
		contacts.add("Snoopy", "Dog", "snoopy@uwo.ca");	
		contacts.add("Felix", "Cat", "felix@uwo.ca");		
		contacts.add("Mickey", "Mouse", "mickey@uwo.ca");
		
		System.out.println(contacts.toString());
		System.out.println("I have " + contacts.getNumFriends() + " friends in my contact list.");
		if(contacts.remove("Snoopy", "Dog"))
		{
			System.out.println("Snoopy Dog was removed successfully");
		}
		else
		{
			System.out.println("Snoopy Dog was not removed successfully");
		}
		if(contacts.remove("George", "Bush"))
		{
			System.out.println("George Bush was removed successfully");
		}
		else
		{
			System.out.println("George Bush was not removed successfully");
		}
		System.out.println(contacts);
	}

}
