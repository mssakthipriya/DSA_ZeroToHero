package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class SubsetSumTargetMemo {
	
	public static boolean checkSubset(int index,int target, int[] arr,int[][] dp) {
		
		if(target == 0) return true;
		if(index==0) return arr[0]==target;
		
		if(dp[index][target]!=-1) return dp[index][target] == 1;
		
		boolean notTake = checkSubset(index-1, target, arr, dp);
		
		boolean take = false;
		if(arr[index]<=target) {
			take = checkSubset(index-1,target-arr[index], arr, dp);
		}

		dp[index][target] = (take||notTake)?1:0;
		
		return take||notTake;
	}
	public static boolean isSubsetSum(int[] arr, int k) {
		int n = arr.length;
		
		int[][] dp = new int[n][k+1];
		
		for(int[] ar : dp) {
			Arrays.fill(ar, -1);
		}
		boolean check = checkSubset(n-1,k,arr,dp);
		
		return check;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 5, 2};
		int k = 6;
		
		boolean check = isSubsetSum(arr,k);
		
		System.out.println(check);
	}

}
