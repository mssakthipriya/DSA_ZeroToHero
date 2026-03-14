package O.SlidingWindowTwoPointer.Medium;

public class CountNiceSub {
	
	public static int getNiceSubCount(int[] nums,int k) {
		int oddCount = 0;
		int subCount = 0;
		int start = 0;
		int end = 0;
		int prefix = 0;
		
		while(end<nums.length) {
			if(nums[end]%2==1) oddCount++;
			
			if(oddCount==k) {
				prefix = 0;
				while(oddCount==k) {
					oddCount-=nums[start]%2;
					start++;
					prefix++;
				}
				
			}
			subCount +=prefix;
			end++;
		}
		
		
		return subCount;
	}
	public static void main(String[] args) {
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		int k = 2;
		
		System.out.println(getNiceSubCount(nums,k));
	}

}
