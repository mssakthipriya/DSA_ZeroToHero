package U.DynamicProgramming.Strings;

import java.util.Arrays;

public class DistinctSubsequecesMemo {
	
	public static int helper(int i, int j, String s, String t,int[][] dp) {
		if(j==t.length()) return 1;
		if(i==s.length()) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int count = 0;
		if(s.charAt(i)==t.charAt(j)) {
			count = helper(i+1, j+1, s, t,dp)+helper(i+1, j, s, t,dp);
		}else {
			count = helper(i+1, j, s, t,dp);
		}
		
		return dp[i][j]=count;
	}
	public static int getDistinctSub(String s, String t) {
		int n = s.length();
		int m = t.length();
		
		int[][] dp = new int[n][m];
		
		for(int[] ar: dp) {
			Arrays.fill(ar, -1);
		}
		
		return helper(0, 0, s, t,dp);
	}
	
	public static void main(String[] args) {
		String s = "babgbag", t = "bag";
		
		int count = getDistinctSub(s,t);
		
		System.out.println(count);
		
	}

}
