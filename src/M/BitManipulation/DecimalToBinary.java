package M.BitManipulation;

public class DecimalToBinary {
	public static int reverse(int bin) {
		int rev=0;
		while(bin!=0) {
			rev*=10;
			rev = rev+(bin%10);
			bin=bin/10;
		}

		return rev;
	}
	public static String getBinary(int n) {
		int bin = 0;
		while(n!=0) {
			bin*=10;
			bin=bin+(n%2);			
			n=n/2;
		}
		int rev = reverse(bin);
		String res = Integer.toString(rev);
		return res;
	}
	
	public static String getBinaryII(int n) {
		String res = "";
		int bin = 0;
		while(n!=0) {
			bin=n%2;			
			n=n/2;
			res = bin+res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 11;
		
		String bin = getBinary(n);
		String bin2 = getBinaryII(n);
		
		System.out.println("The binary form of "+n+" is:"+bin);
		System.out.println("The binary form of "+n+" is:"+bin2);
	}

}
