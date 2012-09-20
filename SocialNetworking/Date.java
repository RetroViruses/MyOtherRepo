
public class Date {

	//variable declaration for year, month, and date of birth
	private int year;
	private int month;
	private int day;
	
	/**
	 * constructor initiating year, month, and date of birth
	 * @param yr year of birth
	 * @param mnth month of birth
	 * @param dy day of birth
	 */
	public Date(int yr, int mnth, int dy){
		year=yr;
		month=mnth;
		day=dy;
	}
	
	/**
	 * returns in a string the full date of birth
	 */
	public String toString(){
		String fullDate;
		fullDate=year+" "+month+" "+day;
		return fullDate;
	}
}
