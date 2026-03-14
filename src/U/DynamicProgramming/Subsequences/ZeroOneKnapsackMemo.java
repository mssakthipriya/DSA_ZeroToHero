package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class ZeroOneKnapsackMemo {
	public static int solve(int ind, int wt, int[] weight, int[] profit,int[][] dp) {
		if(wt==0) return 0;
		
		if(ind==0) {
			if(weight[0]<=wt) return profit[0];
			else return 0;
		}
		
		if(dp[ind][wt]!=-1) return dp[ind][wt];
		
		int notTake = solve(ind-1, wt, weight, profit,dp);
		int take = 0;
		if(weight[ind]<=wt) {
			take = profit[ind] + solve(ind-1, wt-weight[ind], weight, profit,dp);
		}
		
		return dp[ind][wt] = Math.max(notTake, take);
		
	}
	public static int zeroOneKnapSack(int wt, int[] weight, int[] profit) {
		int n = weight.length;
		
		int[][] dp = new int[n][wt+1];
		
		for(int[] ar:dp) {
			Arrays.fill(ar, -1);
		}
		
		return solve(n-1,wt,weight,profit,dp);
	}
	public static void main(String[] args) {
		int w = 4;
		int[] profit = {1, 2, 3};
		int[] weight = {4, 5, 1};
		
		int value = zeroOneKnapSack(w,weight,profit);
		
		System.out.println(value);
	}

}
