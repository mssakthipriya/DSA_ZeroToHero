package I.BinarySearch.OneD;

public class FloorAndCeil {
	
	public static int[] getFloorAndCeil(int[] arr, int num) {
		int floor = -1;
		int ceil = -1;
		int[] nums = {floor,ceil};
		int i=0,j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]==num) {
				floor=mid;
				ceil = mid;
				break;
			}else if(arr[mid]>num) {
				ceil = mid;
				j=mid-1;
			}else {
				floor = mid;
				i = mid+1;
			}
		}
		
		nums[0] = arr[floor];
		nums[1] = arr[ceil];
		
		return nums;
	}

	public static void main(String[] args) {
		int[] arr = {3, 4, 4, 7, 8, 10};
		int num = 5;
		int [] ans = getFloorAndCeil(arr,num);
		System.out.println("The floor of "+num+" in the array is:"+ans[0]);
		System.out.println("The ceil of "+num+" in the array is:"+ans[1]);
	}
}
