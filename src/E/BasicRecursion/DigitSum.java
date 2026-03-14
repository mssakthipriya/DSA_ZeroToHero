package E.BasicRecursion;

public class DigitSum {

	public static int getDigitSum(int n) {
		if(n==0) {
			return 0;
		}
		
		return n%10+getDigitSum(n/10);
	}
	public static void main(String[] args) {
		int n= 5251;
		System.out.println(getDigitSum(n));		
	}
}
