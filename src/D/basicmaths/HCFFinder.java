package D.basicmaths;

public class HCFFinder {
	
	public static int findHCF(int a, int b) {
		int fact=1;
		int n=1;
		int least = Math.min(a, b);
		
		while(n<=least) {
			if((a%n==0)&&(b%n==0)) {
				fact=n;
			}
				n++;

		}


		
		return fact;
	}
	
	public static int findHCFBetter(int a, int b) {

		
		for(int i=Math.min(a, b); i>=1;i--) {
			if((a%i==0)&&(b%i==0)) {
				return i;
			}
		}
				
		return 1;
	}
	
	public static int findHCFOpt(int a, int b) {
		if((a==0||b==0)) {
			return Math.max(a, b);
		}
		return findHCFOpt((Math.max(a, b)-Math.min(a, b)), Math.min(a, b));
	}
	
	public static void main(String[] args) {
		System.out.println(findHCF(20,15));
		System.out.println(findHCFBetter(20,15));
		System.out.println(findHCFOpt(15,20));
	}

}
