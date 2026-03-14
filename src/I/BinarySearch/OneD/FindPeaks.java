package I.BinarySearch.OneD;

public class FindPeaks {

	public static int findPeakElement(int[] nums ) {
		int peak = -1;
		if(nums[0]>nums[1]) return 0;
		if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
		
		int low = 1,high = nums.length-2;
		while(low<=high) {
			int mid = (low+high)/2;
			if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
				return mid;
			}else if(nums[mid]>nums[mid-1]){
				low = mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return peak;
	}
	
	public static void main(String[] args) {
		//int[] arr = {1,2,3,1};
		int[] arr = {1,2,1,3,5,6,4};
		int peak = findPeakElement(arr);
		
		System.out.println(peak+" has a peak in the array.");
	}
}
