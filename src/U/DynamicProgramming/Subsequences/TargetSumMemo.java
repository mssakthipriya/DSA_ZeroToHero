package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class TargetSumMemo {
	public static int getSubsetSum(int ind, int target, int[] nums, int[][] dp) {
		
		if(target==0) return 1;
		
		if(ind==0) {
			if(target==nums[0]) {
				return 1;
			}
			return 0;
		}
		
		if(dp[ind][target]!=-1) return dp[ind][target];
		
		int notTake = getSubsetSum(ind-1, target, nums, dp);
		int take = 0;
		
		if(target>=nums[ind]) {
			take = getSubsetSum(ind-1, target-nums[ind], nums, dp);
		}
		
		return dp[ind][target]=take+notTake;
	}
    public static int findTargetSumWays(int[] nums, int target) {
    	int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
        	sum+=nums[i];
        }
        
        if((sum-target)<0 || (sum-target)%2!=0) return 0;
        
        int targetSum = (sum-target)/2;
        
        int[][] dp = new int[n][targetSum+1];
        
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return getSubsetSum(n-1, targetSum, nums, dp);
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int target = 3;
		
		int ways = findTargetSumWays(nums, target);
		
		System.out.println(ways);
	}

}
