package I.BinarySearch.Answers;

public class SquareRootFinder {
	public static int getSquareRootBS(int num) {
		int i=0;
		int j=num;
		while(i<=j) {
			int mid=(i+j)/2;
			int sq = mid*mid;
			if(sq<=num) {
				i=mid+1;
			}else {
				j=mid-1;
			}
		}
		return j;
	}
	public static int getSquareRootII(int num) {
		int sqrt = (int)Math.sqrt(num);
		return sqrt;
	}
	
	public static int getSquareRoot(int num) {
		int sqrt = 0;
		for(int i=0;i<num;i++) {
			int sq1=i*i;
			if(sq1<=num) {
				sqrt = i;
			}else {
				break;
			}
		}
		
		
		return sqrt;
	}
	public static void main(String[] args) {
		int num = 28;
		
		int sqrt = getSquareRoot(num);
		
		System.out.println("The square root of "+num+" is:"+sqrt);
		System.out.println("The square root of "+num+" is:"+getSquareRootII(num));
		System.out.println("The square root of "+num+" is:"+getSquareRootBS(num));
	}

}
