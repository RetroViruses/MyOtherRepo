
public class Fib {
	public static long fib(long n){
		if (n== 1){
			return 1;
		}
		if (n==0){
			return 0;
		}
		else{
			return (fib(n-1)+fib(n-2));
		}
	}
	public static void main(String args[]){
		int i=0;
		while (i<100){
			System.out.println(i + ": " + fib(i));	
			i++;
		}
	}
}
