import java.util.Date;
import java.text.SimpleDateFormat;

public class CodeFormatting {

	private static void printDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE, dd-MMM-yyyy HH:mm:ss");
		System.out.println("Date: " +

		formatter.format(date));
	}

	private static void printTime() {
		Date time = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Time: " + formatter.format(time));
	}

	public static void main(String[] args) throws Exception {

		System.out.println("I am poorly formatted")

		;

		printDate();
		printTime();
	}
}
