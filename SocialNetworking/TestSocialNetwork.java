import java.io.*;
/**
 * Test program to show that your Assignment 1 classes work as specified
 * @author CS1027 for Asn1
 */
public class TestSocialNetwork {

	public static void main(String[] args) throws Exception {
		
		SocialNetwork contacts = new SocialNetwork();
		
		// get the filename to read from, from the user		     
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in),1);
		System.out.println("Enter name of the file to read from: ");
		String fileName= keyboard.readLine();
		
		// add friends from the file
		contacts.readList(fileName);
		System.out.println(contacts.toString());
		System.out.println("I have " + contacts.getNumFriends() + " friends in my contact list.");
		
		// add contacts
		System.out.println("--------------------------------------");
		contacts.add("Ben", "Dover", "bd@google.com", 1912, 7, 25);
		contacts.add("Rick", "Astley", "ra@aol.com", 1987, 7, 27);
		contacts.add("John", "Doe", "");
		contacts.add("Jimmy", "Bob", "", 1973, 2, 14);
		//print contacts and display the number of them
		System.out.println(contacts.toString());
		System.out.println("I have " + contacts.getNumFriends() + " friends in my contact list.");
		//declares and searches for a person
		Person searchThem=new Person("Rick", "Astley", "rickA@yahoo.com", 1999, 9, 19);
		Person tempPerson;
		tempPerson = contacts.findFriend(searchThem);
		//changes that persons email and birthday to the correct value
		tempPerson.setEmail(searchThem.getEmail());
		tempPerson.setBirthday(searchThem.getBirthday());
		//prints the updated contact list
		System.out.println("--------------------------------------");
		System.out.println(contacts.toString());
		//searches for another person, prints their email and birthdate
		Person searchThem2=new Person("Ben", "Dover", "bd@google.com", 1912, 7, 25);
		tempPerson=contacts.findFriend(searchThem2);
		System.out.println(tempPerson.getEmail());
		System.out.println(tempPerson.getBirthday());
		//searches another person, fails, prints as such
		Person searchThem3=new Person("Jim", "George", "jg@google.com", 1962, 8, 5);
		if (contacts.findFriend(searchThem3) != null){
			tempPerson=contacts.findFriend(searchThem3);
		}
		else{
			System.out.println("That person cannot be found");
		}
		//asks where to write to, writes there
		BufferedReader keyboard2 = new BufferedReader(new InputStreamReader(System.in),1);
		System.out.println("Enter name of the file to write to: ");
		String fileName2= keyboard2.readLine();
		contacts.writeList(fileName2);
	}

}
