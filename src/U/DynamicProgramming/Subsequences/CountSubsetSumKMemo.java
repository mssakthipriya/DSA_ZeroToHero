package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CountSubsetSumKMemo {
	public static int solve(int index, int target, int[] nums,int[][] dp) {
		if(target==0) return 1;
		if(index==0) return nums[index]==target?1:0;
		
		if(dp[index][target]!=-1) return dp[index][target];
		
		int notTake  = solve(index-1, target, nums,dp);
		int take =0;
		if(target>=nums[index]) {
			take = solve(index-1, target-nums[index], nums,dp);
		}
		
		return dp[index][target]=take+notTake;
	}
	public static int countSubsets(int[] nums, int target) {
		int n = nums.length;
		
		int[][] dp = new int[n][target+1];
		
		for(int[] ar : dp) {
			Arrays.fill(ar, -1);
		}
		
		return solve(n-1,target,nums,dp);
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3};
		int k = 3;
		
		int count = countSubsets(arr,k);
		System.out.println(count);
	}

}
