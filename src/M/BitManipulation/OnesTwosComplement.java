package M.BitManipulation;

public class OnesTwosComplement {
	
	public static String getOnesComplement(String s) {
		String comp = "";
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='1') {
				comp+="0";
			}else {
				comp+="1";
			}
		}
		
		return comp;
	}

	public static String getTwosComplement(String s) {
		String ones = getOnesComplement(s);
		int dec = convertBinToDec(ones)+1;
		String twos = convertDecToBin(dec);
		
		return twos;
	}
	
	public static int convertBinToDec(String s) {
		int dec=0;
		int pow =1;
		for(int i=s.length()-1;i>=0;i--) {
			if(s.charAt(i)=='1') {
				dec=dec+pow;
			}
			
			pow = pow*2;
		}
		
		return dec;
	}
	public static String convertDecToBin(int dec) {
		String res = "";
		int x=0;
		while(dec!=0) {
			x = dec%2;
			dec=dec/2;
			res=x+res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s = "1011";
		
		String onesComplement = getOnesComplement(s);
		String twosComplement = getTwosComplement(s);
		
		System.out.println("The ones complement of "+s+" is:"+onesComplement);	
		System.out.println("The twos complement of "+s+" is:"+twosComplement);	
		
	}

}
