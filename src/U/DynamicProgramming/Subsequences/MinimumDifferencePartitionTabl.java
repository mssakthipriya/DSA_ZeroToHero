package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class MinimumDifferencePartitionTabl {
	
	public static boolean getsum(int index,int target,int[] nums,int[][] dp) {
		if(target==0) {
			dp[index][target] = 1;
			return dp[index][target]== 1;
		} 
		if(index==0) {
			dp[index][target]=(nums[index]==target)?1:0;
			return dp[index][target]==1;
		} 
		
		if(dp[index][target]!=-1) return dp[index][target]==1;
		
		boolean notTake = getsum(index-1, target, nums, dp);
		
		boolean take = false;
		if(target>=nums[index]) {
			take = getsum(index-1, target-nums[index], nums, dp);
		}
		dp[index][target] = (take||notTake)?1:0;
		return take||notTake;
	}
    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int i=0;i<n;i++) {
        	sum+=nums[i];
        }
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i=0;i<n;i++) {
        	dp[i][0] = true;
        }
        if(nums[0]<=sum) {
        	dp[0][0] = true;
        }
        for(int index=1;index<n;index++) {
        	for(int target =1;target<=sum;target++) {
        		boolean notTake = dp[index-1][target];
        		
        		boolean take = false;
        		if(target>=nums[index]) {
        			take = dp[index-1][target-nums[index]];
        		}
        		
        		dp[index][target] = take||notTake;
        	}
        }
        
        
        int mini = Integer.MAX_VALUE;
        
        for(int i=0;i<=sum;i++) {
        	if(dp[n-1][i]) {
        		int j = sum-i;
        		int diff = Math.abs(j-i);
        		
        		mini = Math.min(mini, diff);
        	}
        }
        
    	return mini;
    }
	public static void main(String[] args) {
		int[] nums = {3,9,7,3};
		
		int diff = minimumDifference(nums);
		
		System.out.println(diff);
	}
}
