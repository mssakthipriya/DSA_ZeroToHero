package I.BinarySearch.Answers;

public class KthElement {

	public static int findKth(int[] arr1,int[] arr2, int k) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int n=n1+n2;
		if(n1>n2)return findKth(arr2,arr1,k);
		int low = Math.max(0, k-n2);
		int high = Math.min(k, n1);
		
		while(low<=high) {
			int m1 = (low+high)/2; //(low+high)>>1
			int m2 = k-m1;
			
			int l1 = (m1>0)?arr1[m1-1]:Integer.MIN_VALUE;
			int l2 = (m2>0)?arr2[m2-1]:Integer.MIN_VALUE;
			int r1 = (m1<n1)?arr1[m1]:Integer.MAX_VALUE;
			int r2 = (m2<n2)?arr2[m2]:Integer.MAX_VALUE;
			
			if(l1<=r2 && l2<=r1) {
				return Math.max(l1, l2);
			}else if(l2>r1) {
				low=m1+1;
			}else {
				high=m1-1;
			}
		}

		return 0;
	}
	public static void main(String[] args) {
		int[] arr1= {2,5,7};
		int[] arr2= {1,3,6};
		int k = 4;
		int element = findKth(arr1,arr2,k);
		
		System.out.println("The kth element of both arrays is :"+ element);
	}

}
