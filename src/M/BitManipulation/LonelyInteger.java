package M.BitManipulation;

public class LonelyInteger {
	public static int getLoner(int[] arr) {
		int loner =0;
		for(int i=0;i<arr.length;i++) {
			loner=loner^arr[i];
		}
			
		return loner;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,3,2,1};
		
		int loner = getLoner(a);
		
		System.out.println("The lone rin the array is:"+loner);
	}

}
