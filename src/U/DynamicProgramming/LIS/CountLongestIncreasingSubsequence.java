package U.DynamicProgramming.LIS;

import java.util.Arrays;

public class CountLongestIncreasingSubsequence {
	
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        int count = 0;
        int maxi = 0;
        for(int i=0;i<n;i++) {
        	for(int prevInd =0;prevInd <i;prevInd++) {
        		if(nums[i]>nums[prevInd] && dp[i]<dp[prevInd]+1) {
        			dp[i] = dp[prevInd]+1;
        			cnt[i] = cnt[prevInd];
        		}
        		else if(dp[i]==dp[prevInd]+1) {
        			cnt[i]=cnt[i]+cnt[prevInd];
        		}
        	}
			maxi = Math.max(maxi, dp[i]);
        }
        
        for(int i = 0;i<n;i++) {
        	if(dp[i]==maxi) {
        		count+=cnt[i];
        	}
        }
      
       // System.out.println(Arrays.toString(dp));
       // System.out.println(Arrays.toString(cnt));
        
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,4,3,5,4,7,2};
		
		int count = findNumberOfLIS(nums);
		
		System.out.println(count);
	}

}
