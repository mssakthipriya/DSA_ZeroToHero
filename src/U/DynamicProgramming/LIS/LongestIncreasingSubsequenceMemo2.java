package U.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequenceMemo2 {
	

	public static int getLongestIncreasingSub(int[] arr) {
		
		int n = arr.length;
		
		int[] dp = new int[n];
		
		Arrays.fill(dp, 1);
		
		for(int j=1;j<n;j++) {
			int i=0;
			while(i<j) {
				if(arr[i]<arr[j]) {
					dp[j] = dp[i]+1;
				}
				i++;
			}
		}
		
		System.out.println(Arrays.toString(dp));

		int length = 0;
		
		for(int i=0;i<dp.length;i++) {
			length = Math.max(length, dp[i]);
		}
		
		
		return length;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		
		int longestSubLength = getLongestIncreasingSub(arr);
		
		System.out.println(longestSubLength);
	}

}
