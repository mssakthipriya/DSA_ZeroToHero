package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class UnboundedKnapsackMemo {
	
	public static int solve(int ind, int wt, int[] weight, int[] profit,int[][] dp) {
		if(wt==0) return 0;
		if(ind==0) {
			if(weight[0]<=wt) {
				return (wt/weight[0])*profit[0];
			}
			return 0;
		}
		
		if(dp[ind][wt]!=-1) return dp[ind][wt];
		
		int notTake = solve(ind-1, wt, weight, profit,dp);
		
		int take =0;
		if(weight[ind]<=wt) {
			take = profit[ind]+solve(ind, wt-weight[ind], weight, profit,dp);
		}
		
		return dp[ind][wt] = Math.max(notTake, take);
	}
	 public static int unboundedKnapsack(int w, int[] weight, int[] profit) {
		 int n = weight.length;
		 
		 int[][] dp = new int[n][w+1];
		 for (int[] row : dp) Arrays.fill(row, -1);
		 
		 return solve(n-1, w, weight, profit,dp);
	 }
	
	public static void main(String[] args) {
		int w = 8;
		int[] wt = {2, 4, 6};
		int[] val = {5, 11, 13};
		
		int total = unboundedKnapsack(w, wt, val);
		System.out.println(total);
	}

}
