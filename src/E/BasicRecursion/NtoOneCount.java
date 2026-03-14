package E.BasicRecursion;

public class NtoOneCount {
	
	public static void countNtoOne(int n) {
		if(n==0)
			return;
		System.out.println(n);
		countNtoOne(n-1);
	}
	
	public static void main(String[] args) {
		countNtoOne(5);
	}

}
