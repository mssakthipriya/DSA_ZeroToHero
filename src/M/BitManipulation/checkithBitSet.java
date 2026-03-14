package M.BitManipulation;

public class checkithBitSet {
	public static boolean checkIfSetBrut(int n,int i) {
		String rev = "";
		
		while(n!=0) {
			int x = n%2;
			n=n/2;
			rev = x+rev;
		}
		System.out.println(rev);
		if(rev.charAt(i)=='1')
			return true;
		else
			return false;
		
	}
	
	public static boolean checkIfSetOpt(int n,int i) {
		if((n&(1<<i))==0) {
			return false;
		}else {
			return true;
		}	
	}
	public static void main(String[] args) {
		int n=5;
		int i=0;
		boolean check = checkIfSetBrut(n,i);
		System.out.println(check);
		
		boolean check2 = checkIfSetOpt(n,i);
		System.out.println(check2);
	}

}
