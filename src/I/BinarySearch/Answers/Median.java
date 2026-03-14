package I.BinarySearch.Answers;

public class Median {
	public static double findMedian(int[] arr1,int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		if(n1>n2)return findMedian(arr2,arr1);
		int low = 0;
		int high = n1;
		
		while(low<=high) {
			int m1 = (low+high)/2;
			int m2 = ((n1+n2+1)/2)-m1;
			
			int l1 = (m1>0)?arr1[m1-1]:Integer.MIN_VALUE;
			int l2 = (m2>0)?arr2[m2-1]:Integer.MIN_VALUE;
			int r1 = (m1<n1)?arr1[m1]:Integer.MAX_VALUE;
			int r2 = (m2<n2)?arr2[m2]:Integer.MAX_VALUE;
			
			if(l1<=r2 && l2<=r1) {
				if(((n1+n2)%2)==0) return ((double)(Math.max(l1, l2)+Math.min(r1, r2)))/2;
				else return Math.max(l1, l2);
			}else if(l2>r1) {
				low=m1+1;
			}else {
				high=m1-1;
			}
		}

		return 0;
	}
	public static void main(String[] args) {
		int[] arr1= {2,4,6};
		int[] arr2= {1,3,5};
		double median = findMedian(arr1,arr2);
		
		System.out.println("The median of both arrays is :"+ median);
	}

}
