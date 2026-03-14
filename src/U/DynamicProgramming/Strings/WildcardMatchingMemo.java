package U.DynamicProgramming.Strings;

import java.util.Arrays;

public class WildcardMatchingMemo {
	public static boolean isAllStars(String s,int i) {
		for(int k=0;k<i;k++) {
			if(s.charAt(k)!='*') return false;
			
		}
		return true;
	}
	public static boolean solve(int i, int j, String s, String p, int[][] dp) {
		// i for pattern j for text
		if(i<0 && j<0) return true;
		if(i<0 && j>=0) return false;
		if(i>=0 && j<0) return isAllStars(s, i);
		
		if(dp[i][j]!=-1)return dp[i][j]==1;
		
		if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?') {
			dp[i][j] = solve(i-1, j-1, s, p,dp)?1:0;
		}else if(s.charAt(i)=='*') {
			dp[i][j] = solve(i-1, j, s, p,dp)||solve(i, j-1, s, p,dp)?1:0;
		}else {
			dp[i][j]=0;
		}
		
		
		return dp[i][j]==1;
	}
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        int[][] dp = new int[n][m];
        for(int[] ar: dp) {
        	Arrays.fill(ar, -1);
        }
        
        return solve(n-1, m-1, s, p,dp);
    }

	public static void main(String[] args) {
		String S1 = "ab*cd", S2 = "abdefcd";
		
		boolean match = isMatch(S1, S2);
		
		System.out.println(match);
	}
}
