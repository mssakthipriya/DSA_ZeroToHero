package M.BitManipulation;

public class CountConsecutiveOnes {

	public static boolean isConsecutive(int n) {		
		return (n&(n>>1))!=0;
	}
	public static int getConsecutiveCount(int n) {		
		int count = 0;
		while(n!=0) {
			n=n&(n>>1);
			count++;
		}
		
		return count;
	}
	public static void main(String[] args) {
		int n=101;
		
		boolean check = isConsecutive(n);
		
		System.out.println(check);
		int count = getConsecutiveCount(n);
		System.out.println("The count of consecutive ones is:"+count);
	}
}
