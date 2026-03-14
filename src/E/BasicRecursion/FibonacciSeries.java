package E.BasicRecursion;

public class FibonacciSeries {
	
	public static int getFib(int n) {
		if(n<=1) {
			
			return n;
		}
		
		return getFib(n-1)+getFib(n-2);
	}
	
	public static void main(String[] args) {
		int n=6;
		for (int i = 1; i <= n; i++) {
			System.out.println(getFib(i));
		}

	}

}
