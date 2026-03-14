package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class EvaluateBooleanExpToTrue {
	static int mod = 1000000007;
	
	public static int solve(int i, int j, int flag, String exp,int[][][] dp) {
		if(i>j) return 0;
		if(i==j) {
			if(flag==1) {
				return exp.charAt(i)=='T'?1:0;
			}else {
				return exp.charAt(i)=='F'?1:0;
			}
		} 
		
		if(dp[i][j][flag]!=-1) return dp[i][j][flag];
		
		int ways = 0;
		for(int k=i+1; k<=j-1;k=k+2) {
			int lF = solve(i, k-1, 0, exp,dp);
			int rF = solve(k+1, j, 0, exp,dp);
			int lT = solve(i, k-1, 1, exp,dp);
			int rT = solve(k+1, j, 1, exp,dp);
			
			if(exp.charAt(k)=='&') {
				if(flag==1)ways = (ways+(lT*rT)%mod)%mod;
				else ways = (ways+(lT*rF)%mod+(lF*rT)%mod+(lF*rF)%mod)%mod;
				
			}else if(exp.charAt(k)=='|') {
				if(flag==1)ways = (ways+(lT*rF)%mod+(lF*rT)%mod+(lT*rT)%mod)%mod;
				else ways = (ways+(lF*rF)%mod)%mod;
				
			}else {
				if(flag==1)ways = (ways+(lF*rT)%mod+(lT*rF)%mod)%mod;
				else ways = (ways+(lT*rT)%mod+(lF*rF)%mod)%mod;
			}
		}
		
		return dp[i][j][flag] = ways;
	}
	public static int evaluateExp(String exp) {
		int n = exp.length();
		
		int[][][] dp = new int[n][n][2];
		for(int[][] ar1 : dp) {
			for(int[] ar2 : ar1) {
				Arrays.fill(ar2, -1);
			}
		}
		
		return solve(0, n-1, 1, exp,dp);
	}
	
	public static void main(String[] args) {
		String exp = "F|T^F";
		
		int ways = evaluateExp(exp);
		System.out.println(ways);
	}

}
