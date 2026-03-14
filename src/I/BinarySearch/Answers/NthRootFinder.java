package I.BinarySearch.Answers;

public class NthRootFinder {
	public static int powFinder(int num,int n) {
		int pow=1;
		for(int i=1;i<=n;i++) {
			pow*=num;
			if(pow>num)
				return 2;
		}
		if(pow==num) return 1;
		
		return 0;
	}
	
	public static int getNthRoot(int num, int n) {
		int i=1;
		int j=num;
		while(i<=j) {
			int mid = (i+j)/2;
			int pow = powFinder(mid,n);
			if(pow==1) {
				return mid;
			}else if(pow==0) {
				i=mid+1;
			}else {
				j=mid-1;
			}
		}
					
		
		
		return -1;
	}

	public static void main(String[] args) {
		int num = 27;
		int n = 3;
		
		int nthRoot = getNthRoot(num,n);
		System.out.println("The nth root of num is"+nthRoot);
	}
}
