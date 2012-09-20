
public class TowersOfHanoi {
	public static int towers(int numDisks, int start, int end, int temp){

		if (numDisks==1){
			moveOneDisk(start,end);
		}
		else{
			towers(numDisks-1,start,temp,end);
			moveOneDisk (start,end);
			towers(numDisks-1,temp,end,start);
			}
		return start;
		}
	public static int moveOneDisk (int start, int end){
		return start;
	}
}