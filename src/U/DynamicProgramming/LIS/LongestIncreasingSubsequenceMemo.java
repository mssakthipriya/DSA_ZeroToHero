package U.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequenceMemo {
	
	public static int getLIS(int index,int prev,int n, int[] arr,int[][] dp) {
		if(index==n) return 0;
		
		if(dp[index][prev+1]!=-1) return dp[index][prev+1];
		
		int len = getLIS(index+1,index, n, arr,dp);
		if(prev == -1 || arr[index]>arr[prev]) {
			len = Math.max(len, 1+getLIS(index+1, index, n, arr,dp));
		}
		dp[index][prev+1] = len;
				
		return len;
	}
	public static int getLongestIncreasingSub(int[] arr) {
		
		int n = arr.length;
		
		int[][] dp = new int[n][n+1];
		
		for(int[] ar : dp) {
			Arrays.fill(ar, -1);
		}
		
		int length = getLIS(0,-1,n,arr,dp);
		
		return length;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		
		int longestSubLength = getLongestIncreasingSub(arr);
		
		System.out.println(longestSubLength);
	}

}
