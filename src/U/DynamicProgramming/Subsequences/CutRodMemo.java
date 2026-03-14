package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CutRodMemo {
	public static int solve(int ind, int length,int[] price,int[][] dp) {
		if(length==0) return 0;
		
		if(ind==0) {
			return length*price[0];
		}
		
		if(dp[ind][length]!=-1) return dp[ind][length];
		
		int notTake = solve(ind-1, length, price, dp);
		
		int take = 0;
		int rodLen = ind+1;
		if(rodLen<=length) {
			take = price[ind]+solve(ind, length-rodLen, price, dp);
		}
		
		return dp[ind][length] = Math.max(notTake, take);
		
	}
	public static int rodCutting(int[] price, int n) {
		
		int[][] dp = new int[n][n+1];
		
		for(int[] row:dp) {
			Arrays.fill(row, -1);
		}
		
		return solve(n-1, n, price, dp)	;	
	}
	public static void main(String[] args) {
		int[] price = {1, 6, 8, 9, 10, 19, 7, 20};
		int n = 8;
		
		int cost = rodCutting(price, n);
		
		System.out.println(cost);
	}

}
