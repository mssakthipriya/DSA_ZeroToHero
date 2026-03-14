package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CountSubsetSumKTabl {
	

	public static int countSubsets(int[] nums, int k) {
		int n = nums.length;
		
		int[][] dp = new int[n][k+1];
		
		dp[0][0] = 1;
		if(nums[0]<=k) dp[0][nums[0]]=1;
		
		for(int index=1;index<n;index++) {
			for(int target=0;target<=k;target++) {
				int notTake  = dp[index-1][target];
				int take =0;
				if(target>=nums[index]) {
					take = dp[index-1][target-nums[index]];
				}
				
				dp[index][target]=take+notTake;
			}
		}
		
		for(int[] ar: dp) {
			System.out.println(Arrays.toString(ar));
		}
		

		return dp[n-1][k];
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3};
		int k = 3;
		
		int count = countSubsets(arr,k);
		System.out.println(count);
	}

}
