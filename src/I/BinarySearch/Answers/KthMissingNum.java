package I.BinarySearch.Answers;

public class KthMissingNum {
	

	public static int getKthMissingNum(int[] arr,int k) {
		int low=0;
		int high=arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			int missk = arr[mid]-(mid+1);
			if(missk<k) {
				low = mid+1;
			}else {
				high=mid-1;
			}			
		}
		System.out.println(high);
		
		return high+1+k;
	}

	public static void main(String[] args) {
		int[] arr = {4,7,9,10};
		int k=1;
		int num = getKthMissingNum(arr,k);
		System.out.println("The kth missing number in the series is:"+num);
	}
}
