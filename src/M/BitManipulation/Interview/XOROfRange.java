package M.BitManipulation.Interview;

public class XOROfRange {
	
	public static int getRangefrom1(int n) {
		if(n%4==0) return n;
		else if(n%4==1) return 1;
		else if(n%4==2) return n+1;
		else if(n%4==3) return 0;
		
		return -1;
	}
	public static int getRange(int a, int b) {
		
		return getRangefrom1(a-1)^getRangefrom1(b);
		
	}
	public static void main(String[] args) {
		int n = 6;
		
		int xor1 = getRangefrom1(n);
		System.out.println("The xor of numbers from 1 to "+n+" is:"+xor1);
		int a=4,b=7;
		int xor2 = getRange(a,b);
		System.out.println("The xor of numbers from "+a+" to "+b+" is:"+xor2);
	}

}
