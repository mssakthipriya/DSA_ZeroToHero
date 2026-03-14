package O.SlidingWindowTwoPointer.Medium;

public class BinarySubArraySum {
	
	public static int getSubWithSum(int[] nums,int goal) {
		int count=0;
		int start=0;
		int end = 0;
		int sum = 0;
		int prefixZeros =0;
		while(end<nums.length) {
			sum+=nums[end];
			
			while(start<end &&(sum>goal || nums[start]==0)) {
				if(nums[start]==1) {
					prefixZeros=0;
				}else {
					prefixZeros++;
				}
				sum-=nums[start];
				start++;
			}
			if(sum==goal) {
				count+=1+prefixZeros;
			}
			end++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0,1,0,1};
		int goal = 2;
		
		System.out.println(getSubWithSum(nums,goal));
	}

}
