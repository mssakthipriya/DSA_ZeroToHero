package I.BinarySearch.Answers;

public class SmallestDivisor {
	
	public static int getDividerSum(int arr[],int div) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum+=(int)Math.ceil((double)arr[i]/(double)div);
		}
		return sum;
	}
	public static int getSmallestDivisor(int[] arr, int limit) {
		int low =1;
		int high=0;
		if(arr.length>limit) return -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>high)
				high=arr[i];
		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			int sum = getDividerSum(arr, mid);
			if(sum<=limit) {
				high=mid-1;
			}else {
				low=mid+1;
			}		

		}
		return low;

	}
	
	public static void main(String[] args) {
		int[] arr = {8,4,2,3};
		int limit = 10;
		int divider = getSmallestDivisor(arr,limit);
		System.out.println("The smallest divider that doesnt exceed the limit is: "+divider);
	}
 
}
