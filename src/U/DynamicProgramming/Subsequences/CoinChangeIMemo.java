package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CoinChangeIMemo {
	public static int solve(int ind, int[] coins, int amount,int[][] dp) {
		
		if(amount==0) return 0;
		
		if(ind==0) {
			if(amount%coins[0]==0) {
				return amount/coins[0];
			}
			return Integer.MAX_VALUE;
		}
		if(dp[ind][amount]!=-1) return dp[ind][amount]; 
		int notTake = solve(ind-1, coins, amount,dp);
		
		int take = Integer.MAX_VALUE;
		
		if(amount>=coins[ind]) {
			take = 1+ solve(ind, coins, amount-coins[ind],dp);
		}		
		
		int ans = Math.min(notTake, take);
		
		dp[ind][amount] = ans;
		
		return ans;
	}
	
	 public static int coinChange(int[] coins, int amount) {
		 int n = coins.length;
		 
		 int[][] dp = new int[n][amount+1];
		 
		 for(int[] row:dp) {
			 Arrays.fill(row, -1);
		 }
		 
		 int ans = solve(n-1, coins, amount,dp);
		 
		 return ans==Integer.MAX_VALUE?-1:ans;
	 }
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		
		int count = coinChange(coins, amount);
		
		System.out.println(count);
	}
}
