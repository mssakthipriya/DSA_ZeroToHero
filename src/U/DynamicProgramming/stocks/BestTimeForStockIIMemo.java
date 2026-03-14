package U.DynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeForStockIIMemo {

	public static long getMaxProfit(int index, int n, int buy, int[] prices, long[][] dp) {
		
		if(index==n) return 0;
		
		long profit = 0;
		
		if(dp[index][buy]!=-1) return dp[index][buy];
		
		if(buy==0) {
			profit = Math.max(-prices[index]+getMaxProfit(index+1, n, 1, prices, dp), getMaxProfit(index+1, n, 0, prices, dp));
		}else {
			profit = Math.max(prices[index]+getMaxProfit(index+1, n, 0, prices, dp), getMaxProfit(index+1, n, 1, prices, dp));
		}
		
		dp[index][buy] = profit;
		
		return profit;
	}
	public static long maxProfit(int[] prices) {
		int n = prices.length;
		
		long[][] dp = new long[n][2];
		
		for(long[] arr: dp) {
			Arrays.fill(arr, -1);
		}
		
		long maxProfit = getMaxProfit(0,n,0,prices,dp);
		
		return maxProfit;
	}
	public static void main(String[] args) {
		 int[] stocks={7,1,5,3,6,4};
		 
		 long profit = maxProfit(stocks);
		 
		 System.out.println(profit);
	}
}
