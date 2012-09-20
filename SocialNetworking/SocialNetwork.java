//import statements
import java.util.*;

/**
 * Class that represents a social network as a list of persons (friends or
 * contacts)
 * 
 * @author CS1027
 */
public class SocialNetwork {

	private final int DEFAULT_MAX_FRIENDS = 10; // default size of array

	/* Attribute declarations */
	private Person[] friendList; // array of persons (list of friends)
	private int numFriends; // current number of persons in list

	/**
	 * Constructor creates person array of default size
	 */
	public SocialNetwork() {
		friendList = new Person[DEFAULT_MAX_FRIENDS];
		numFriends = 0;
	}

	/**
	 * Constructor creates person array of specified size
	 * 
	 * @param max
	 *            maximum size of array
	 */
	public SocialNetwork(int max) {
		friendList = new Person[max];
		numFriends = 0;
	}

	/**
	 * add method adds a person to the list
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param email email address
	 */
	public void add(String firstName, String lastName, String email) {
		// create a new Person objetc
		Person friend = new Person(firstName, lastName, email);

		// add it to the array of friends
		// if array is not big enough, double its capacity automatically
		if (numFriends == friendList.length)
			expandCapacity();

		// add reference to friend at first free spot in array
		friendList[numFriends] = friend;
		numFriends++;
	}

	/**
	 * add method adds a person to the list
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param email email address
	 * @param yr year of birth
	 * @param mnth month of birth
	 * @param dy date of birth
	 */
	public void add(String firstName, String lastName, String email, int yr,
			int mnth, int dy) {
		// create a new Person object
		Person friend = new Person(firstName, lastName, email, yr, mnth, dy);
		// add it to the array of friends
		// if array is not big enough, double its capacity automatically
		if (numFriends == friendList.length)
			expandCapacity();

		// add reference to friend at first free spot in array
		friendList[numFriends] = friend;
		numFriends++;
	}

	/**
	 * remove method removes a specified friend from the list
	 * 
	 * @param firstName first name of person to be removed
	 * @param lastName last name of person to be removed
	 * @return true if friend was removed successfully, false otherwise
	 */
	public boolean remove(String firstName, String lastName) {
		final int NOT_FOUND = -1;
		int search = NOT_FOUND;
		Person target = new Person(firstName, lastName, "");

		// if list is empty, can't remove
		if (numFriends == 0) {
			return false;
		}
		// search the list for the specified friend
		for (int i = 0; i < numFriends && search == NOT_FOUND; i++)
			if (friendList[i].equals(target))
				search = i;

		// if not found, can't remove
		if (search == NOT_FOUND)
			return false;

		// target person found, remove by replacing with last one in list
		friendList[search] = friendList[numFriends - 1];
		friendList[numFriends - 1] = null;
		numFriends--;

		return true;
	}

	/**
	 * toString method returns a string representation of all persons in the list
	 * @return first name and last name, email address, and birthday of each
	 *         person (if available)
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < numFriends; i++) {
			s = s + friendList[i].toString() + "\n";
		}
		return s;
	}

	/**
	 * expandCapacity method is a helper method that creates a new array to
	 * store friends with twice the capacity of the existing one
	 */
	private void expandCapacity() {
		Person[] largerList = new Person[friendList.length * 2];
		for (int i = 0; i < friendList.length; i++)
			largerList[i] = friendList[i];

		friendList = largerList;
	}

	/**
	 * returns the number of friends that are currently listed
	 * 
	 * @return the number of friends
	 */
	public int getNumFriends() {
		int numFri = numFriends;
		return numFri;
	}

	/**
	 * set the number of friends to 0, therby reseting the number of friends
	 */
	public void clearFriends() {
		numFriends = 0;
	}

	/**
	 * If the given person is the same as a person in the list, returns
	 * that person. Else, returns null
	 * @param target Person, used in the search
	 * @return the location in the array of that person, or the null reference
	 */
	public Person findFriend(Person target) {
		final int NOT_FOUND = -1;
		int search = NOT_FOUND;
		Person returnValue;
		// search the list for the specified friend
		for (int i = 0; i < numFriends && search == NOT_FOUND; i++) {
			if (friendList[i].equals(target)) {
				search = i;
			}
		}

		// if not found, return a string saying so
		if (search == NOT_FOUND) {
			returnValue = null;
			return returnValue;
		} else {
			returnValue = friendList[search];
			return returnValue;
		}
	}

	/**
	 * readList method adds into the social network list from a file
	 * @param fileName filename of file that contains friend information
	 */
	public void readList(String fileName) throws Exception {

		// create object that controls file reading and opens the file

		InStringFile reader = new InStringFile(fileName);
		System.out.println("\nReading from file " + fileName + "\n");

		// read data from file one line at a time

		String line;
		StringTokenizer tokenizer;
		String firstName, lastName, email;
		int year, month, day;
		do {
			line = (reader.read());

			// get person info from line read in from file, one at a time,
			// Note: it is assumed that each line of the disk file will have
			// all 6 items, separated by white space

			tokenizer = new StringTokenizer(line);
			firstName = tokenizer.nextToken();
			lastName = tokenizer.nextToken();
			email = tokenizer.nextToken();
			year = Integer.parseInt(tokenizer.nextToken());
			month = Integer.parseInt(tokenizer.nextToken());
			day = Integer.parseInt(tokenizer.nextToken());

			// if the email is unknown, make it blank
			if (email == "?") {
				email = "";
			}
			// add person to the list
			Person addPerson;
			if (year == 0) {
				addPerson = new Person(firstName, lastName, email);
			} else {
				addPerson = new Person(firstName, lastName, email, year, month,
						day);
			}
			// add reference to friend at first free spot in array
			friendList[numFriends] = addPerson;
			numFriends++;
		} while (!reader.endOfFile());

		reader.close();
	}
	/**
	 * A method that writes the string of
	 * @param fileName the filename to save the file to
	 */
	public void writeList(String fileName) {
		int tempFriends=numFriends;
		OutStringFile out1 = new OutStringFile(fileName);

		for (int i=0; i<tempFriends; i++){
			String information = friendList[i].toString();
			information=information+"\n";
			out1.write(information);
			}
		out1.close();

	}

	/**
	 * test harness
	 */
	public static void main(String[] args) {
		SocialNetwork socNet = new SocialNetwork();
		socNet.add("Bugs", "Bunny", "bb@google.com", 1930, 5, 9);
		socNet.add("Yacko", "Warner", "yw@yahoo.com", 1950, 8, 7);
		socNet.add("Donald", "Duck", "dd@hotmail.com", 1920, 4, 11);
		System.out.println(socNet);
		System.out.println("Before Clearing: " + socNet.getNumFriends());
		socNet.clearFriends();
		System.out.println("After Clearing: " + socNet.getNumFriends());
	}
}
