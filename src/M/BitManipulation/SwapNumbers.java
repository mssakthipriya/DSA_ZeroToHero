package M.BitManipulation;

public class SwapNumbers {
	
	public static void swap(int a, int b) {
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("After swapping a = "+a+", b = "+b);
	}
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		swap(a,b);
		
	}

}
