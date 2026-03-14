package H.Arrays.Easy;

public class MissingNumber {
	
	public static int findMissingNumXOR(int[] nums) {
		int n = nums.length;
		int sum =n*(n+1)/2;
		
		for(int i=0;i<n;i++) {
			sum=sum^nums[i];

		}

		return sum;
	}
	
	public static int findMissingNum(int[] nums) {
		int n = nums.length;
		System.out.println(n);
		int sum =n*(n+1)/2;
		int count = 0;
		for(int i=0;i<n;i++) {
			count+=nums[i];

		}

		return sum-count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0};
		System.out.println("The missing number in the array is:"+ findMissingNum(arr));
		System.out.println("The missing number in the array is:"+ findMissingNumXOR(arr));
	}

}
