package O.SlidingWindowTwoPointer.Medium;

public class MaxConsecutiveOnesIII {
	public static int getMaxConsecutiveOnes(int[] nums,int k) {
		int max=0;
		int start=0;
		int end = 0;
		while(end<nums.length) {
			if(nums[end]==0) {
				k--;
			}
			if(k<0) {
				if(nums[start]==0) {
					k++;
				}
				start++;
			}
			if(k>=0) {
				max = Math.max(max, end-start+1);
			}
			end++;
		}
		
		
		return max;
	}
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		//int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		//int k = 2;
		
		System.out.println(getMaxConsecutiveOnes(nums,k));
	}

}
