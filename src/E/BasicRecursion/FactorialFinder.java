package E.BasicRecursion;

public class FactorialFinder {
	
	public static int getFactorial(int n) {
		if(n<=1)
			return n;
		return n*getFactorial(n-1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(getFactorial(5));
	}

}
