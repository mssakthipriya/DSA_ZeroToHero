package E.BasicRecursion;

public class PrintNTimes {
	
	public static void nPrints(int n) {
		int count = 0;
		if(count==n)
			return;
		
		count++;
		System.out.println("Print no:"+n);
		nPrints(n-1);

		
	}
	
	public static void main(String[] args) {
		nPrints(11);
	}

}
