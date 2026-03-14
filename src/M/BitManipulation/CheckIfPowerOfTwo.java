package M.BitManipulation;

/***
 All the numbers which are the power of two only have one set bit
 1  -> 2^0 -> 00000001
 2  -> 2&1 -> 00000010
 4  -> 2^0 -> 00000100
 8  -> 2&1 -> 00001000
 16 -> 2^0 -> 00010000
 32 -> 2&1 -> 00100000
 64 -> 2^0 -> 01000000
 128-> 2&1 -> 10000000 etc
 ***/
public class CheckIfPowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		if(n==0) return false;
		
		return (n&(n-1))==0;
	}
	public static void main(String[] args) {
		int n=128;
		System.out.println(isPowerOfTwo(n));
	}

}
