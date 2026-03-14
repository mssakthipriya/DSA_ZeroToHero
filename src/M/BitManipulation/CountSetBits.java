package M.BitManipulation;
//Kernighan's Algorithm
public class CountSetBits {
	
	public static int countSetBits(int n) {
		int count = 0;
		
		while(n>0) {
			//n&(n-1) sets the rightmost set bit to zero
			n=n&(n-1);
			System.out.println(n);
			count++;
		}
		
		
		return count;
	}
	public static void main(String[] args) {
		int n = 42;
		
		int count = countSetBits(n);
		
		System.out.println("The number of set bits is:"+count);
	}

}
