package U.DynamicProgramming;

import java.util.Arrays;

public class MemoizationFib {
	public static int getFibonacci(int n,int[] dp) {
		if(n<=1) return n;	
		
		if(dp[n]!=-1) return dp[n];
		
		return getFibonacci(n-1,dp)+getFibonacci(n-2,dp);
	}
	public static void main(String[] args) {
		int n=6;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(getFibonacci(n,dp));
	}

}
