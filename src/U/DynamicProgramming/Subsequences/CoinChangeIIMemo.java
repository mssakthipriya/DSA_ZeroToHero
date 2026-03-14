package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class CoinChangeIIMemo {
	
    public static int solve(int ind, int amount, int[] coins,int[][] dp) {
        
    	if(amount == 0) return 1;
    	
        if(ind==0) {
        	if(amount%coins[0]==0) {
        		return 1;
        	}else {
        		return 0;
        	}
        }
        
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        
        int notTake = solve(ind-1, amount, coins,dp);
        
        int take = 0;
        if(amount>=coins[ind]) {
        	take = solve(ind, amount-coins[ind], coins,dp);
        }
        
        return dp[ind][amount]=take+notTake;
    }
    public static int change(int amt, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amt+1];
        
        for(int[] row : dp) {
        	Arrays.fill(row, -1);
        }
        
        return solve(n-1, amt, coins,dp);
    }
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		
		int ways = change(amount, coins);
		
		System.out.println(ways);
	}

}
