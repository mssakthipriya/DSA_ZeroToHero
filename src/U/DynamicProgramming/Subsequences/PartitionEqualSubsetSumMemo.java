package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSumMemo {

	public static boolean solve(int index, int sum, int[] nums, int[][] dp) {
		
		if(sum==0) return true;
		if(index==0) return nums[index]==sum;
		
		if(dp[index][sum]!=-1) return dp[index][sum]==1;
			
		boolean notTake = solve(index-1, sum, nums, dp);
		
		boolean take = false;
		if(nums[index]<=sum) {
			take = solve(index-1, sum-nums[index], nums, dp);
		}
		
		dp[index][sum]=(take||notTake)?1:0;
		
		return take||notTake;
	}
    public static  boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
        	sum+=nums[i];
        }
        
        if(sum%2==1) return false;
        else sum = sum/2;
        
        int[][] dp = new int[n][sum+1];
        
        for(int[] arr:dp) {
        	Arrays.fill(arr, -1);
        }
        
        return solve(n-1,sum,nums,dp);
    }
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		
		boolean check = canPartition(nums);
		
		System.out.println(check);
	}
}
