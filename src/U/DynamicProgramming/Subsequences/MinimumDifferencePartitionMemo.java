package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class MinimumDifferencePartitionMemo {

	
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
        int[][] dp = new int[n][sum+1];
        
        for(int[] ar : dp) {
        	Arrays.fill(ar, -1);
        }
        
        for(int i=0;i<=sum;i++) {
        	getsum(n-1,i, nums, dp);
        }
        
        int mini = Integer.MAX_VALUE;
        
        for(int i=0;i<=sum;i++) {
        	if(dp[n-1][i]==1) {
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
