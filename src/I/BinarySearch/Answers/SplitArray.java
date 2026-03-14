package I.BinarySearch.Answers;

public class SplitArray {
	public static int getPartitions(int[] arr,int sum) {
		int count=1;
		int tot = 0;
		for(int i=0;i<arr.length;i++) {
			if(tot+arr[i]>sum) {
				count++;
				tot=arr[i];
			}else {
				tot+=arr[i];
			}
		}
		
		
		return count;
	}
	public static int getMaxSubSum(int[] arr, int k) {
		int low = arr[0];
		int high = 0;
		
		for(int i=0;i<arr.length;i++) {
			low = Math.max(low, arr[i]);
			high+=arr[i];
		}
		
		while(low<=high) {
			int mid=(low+high)/2;
			
			int part = getPartitions(arr,mid);
			if(part>k) {
				low=mid+1;
			}else {
				high=mid-1;
			}
			
		}
		
		
		return low;
	}
	public static void main(String[] args) {
		//int[] arr = {3,5,1};
		int[] arr = {1,2,3,4,5};
		int k = 3;
		int max = getMaxSubSum(arr,k);
		System.out.println("The maximum subarray sum of the partitions is:"+max);
		
	}

}
 