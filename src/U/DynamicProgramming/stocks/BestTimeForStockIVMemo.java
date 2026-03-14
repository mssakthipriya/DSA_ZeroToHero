package U.DynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeForStockIVMemo {
	
    public static int getMaxProfit(int index, int n, int buy,int k, int[] prices,int[][][] dp) {
        
    	if(index==n || k ==0) return 0;
    	
    	int profit = 0;
    	
    	if(dp[index][buy][k]!=-1) return dp[index][buy][k];
    	
    	if(buy==0) {
    		profit = Math.max(-prices[index]+getMaxProfit(index+1, n, 1, k, prices, dp), getMaxProfit(index+1, n, 0, k, prices, dp));
    	}else {
    		profit = Math.max(prices[index]+getMaxProfit(index+1, n, 0, k-1, prices, dp), getMaxProfit(index+1, n, 1, k, prices, dp));
    	}
    	
    	dp[index][buy][k] = profit;
    	
    	return profit;
    }
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
    	if(n==0) return 0;
    	
    	int[][][] dp = new int[n][2][k+1];
    	
    	for(int[][] ar1: dp) {
    		for(int[] ar2:ar1) {
    			Arrays.fill(ar2, -1);
    		}
    	}
    	
    	return getMaxProfit(0, n, 0, k, prices, dp);
    }
	public static void main(String[] args) {
		int k = 2;
		int[] prices = {3,2,6,5,0,3};
		
		int profit = maxProfit(k, prices);
		
		System.out.println(profit);
	}


}
