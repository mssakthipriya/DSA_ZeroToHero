package M.BitManipulation;

public class BinaryToDecimal {
	public static int getBinary(String s) {
		int dec = 0;
		int index=0;
		int n=s.length()-1;
		while(index!=s.length()) {
			int x = s.charAt(index)-48;
			dec += (int) (x*(Math.pow(2, n-index)));
			index++;
		}		
		return dec;
	}
	public static int getBinaryII(String s) {
		int dec = 0;
		int n=s.length()-1;

		int pow = 1;
		for(int i=n;i>=0;i--) {
			int x = s.charAt(i)-48;
			if(x==1) {
				dec=dec+pow;
			}
			pow*=2;
		}
		
		return dec;
	}
	public static void main(String[] args) {
		String s = "1011";
		
		int dec = getBinary(s);
		int dec2 = getBinaryII(s);
		
		System.out.println("The decimal value of "+s+" is:"+dec);
		System.out.println("The decimal value of "+s+" is:"+dec2);
	}

}
