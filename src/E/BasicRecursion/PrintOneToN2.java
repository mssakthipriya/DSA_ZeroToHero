package E.BasicRecursion;

public class PrintOneToN2 {
	
	public static void printUtility(int n, int count) {
		if(count >n)
			return;
		System.out.println(count);
		printUtility(n, count+1);
	}
	
	public static void printNumber(int n) {
		int count =0;

		printUtility(n,count+1);
	}
	public static void main(String[] args) {
		int n = 10;
		printNumber(10);
	}

}
