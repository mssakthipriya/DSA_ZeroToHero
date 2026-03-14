package U.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequenceTabl {
	

	public static int getLongestIncreasingSub(int[] arr) {
		
		int n = arr.length;
		
		int[][] dp = new int[n+1][n+1];
		
		for(int ind = n-1;ind>=0;ind--) {
			for(int prev = ind-1;prev>=-1;prev--) {
				int len = dp[ind+1][prev+1];
				if(prev == -1 || arr[ind]>arr[prev]) {
					len = Math.max(len, 1+dp[ind+1][ind+1]);
				}
				dp[ind][prev+1] = len;
			}
		}
		

		
		for(int[] ar: dp) {
			System.out.println(Arrays.toString(ar));
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		
		int longestSubLength = getLongestIncreasingSub(arr);
		
		System.out.println(longestSubLength);
	}

}
