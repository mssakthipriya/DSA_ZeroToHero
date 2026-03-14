package U.DynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeForStockFeesMemo {
	
    public static int getMaxProfit(int index, int n, int buy, int fee, int[] prices, int[][] dp) {
       
    	if(index==n) return 0;
    	
    	if(dp[index][buy]!=-1) return dp[index][buy];
    	
    	int profit = 0;
    	
    	if(buy == 0) {
    		profit = Math.max(-prices[index]+getMaxProfit(index+1, n, 1, fee, prices, dp),
    				getMaxProfit(index+1, n, 0, fee, prices, dp));
    	}else {
    		profit = Math.max(prices[index]-fee+getMaxProfit(index+1, n, 0, fee, prices, dp),
    				getMaxProfit(index+1, n, 1, fee, prices, dp));    		
    	}
    	
    	dp[index][buy] = profit;
    	
    	return profit;
    }
	
    public static int maxProfit(int[] prices, int fee) {
      int n = prices.length;
      if(n==0) return 0;
    
      int[][] dp = new int[n][2];
      
      for(int[] ar : dp) {
    	  Arrays.fill(ar, -1);
      }
    	
    	return getMaxProfit(0, n, 0, fee, prices, dp);
    }
	
	public static void main(String[] args) {
		int fee = 2;
		int[] prices = {1, 3, 2, 8, 4, 9};
		
		int profit = maxProfit(prices,fee);
		
		System.out.println(profit);
	}

}
