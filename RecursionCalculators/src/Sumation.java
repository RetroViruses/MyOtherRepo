
public class Sumation {
	public static int sumation(int n){
		if (n==0){
			return 0;
		}
		else{
			return (n+sumation(n-1));
		}
	}
	public static void main(String args[]){
		System.out.println(sumation(5));	
	}
}
