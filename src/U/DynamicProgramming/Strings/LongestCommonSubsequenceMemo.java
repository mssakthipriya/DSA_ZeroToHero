package U.DynamicProgramming.Strings;

import java.util.Arrays;

public class LongestCommonSubsequenceMemo {
	public static int solve(int i, int j, String s1, String s2,int[][] dp) {
		if(i<0 || j<0) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j] ;
		
		if(s1.charAt(i)==s2.charAt(j)) return 1+solve(i-1, j-1, s1, s2,dp);		

		return dp[i][j] = Math.max(solve(i-1, j, s1, s2,dp), solve(i, j-1, s1, s2,dp));
	}
	public static int longestCommonSub(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n][m];
		
		for(int[] ar : dp) {
			Arrays.fill(ar, -1);
		}
		return solve(n-1, m-1, s1, s2, dp);
	}
	public static void main(String[] args) {
		String str1 = "abcd", str2="bdef";
		
		int length = longestCommonSub(str1,str2);
		
		System.out.println(length);
	}

}
