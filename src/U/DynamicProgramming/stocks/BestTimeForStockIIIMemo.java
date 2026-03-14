package U.DynamicProgramming.stocks;

import java.util.Arrays;

public class BestTimeForStockIIIMemo {
	
	public static long getMaxProfit(int index, int n, int buy, int cap, int[] prices, long[][][] dp) {
		
		if(index==n || cap == 0) return 0;
		
		if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
		
		long profit = 0;	
		
		if(buy==0) {
			profit = Math.max(-prices[index]+getMaxProfit(index+1, n, 1, cap, prices, dp),
					getMaxProfit(index+1, n, 0, cap, prices, dp));
		}else {
			profit = Math.max(prices[index]+getMaxProfit(index+1, n, 0, cap-1, prices, dp),
					getMaxProfit(index+1, n, 1, cap, prices, dp));
		}
		
		dp[index][buy][cap] = profit;
		
		return profit;
	}
	
    public static long maxProfit(int[] prices) {
        
    	int n = prices.length;
    	if(n==0) return 0;
    	
    	long[][][] dp = new long[n][2][3];
    	
    	for(long[][] ar1 : dp) {
    		for(long[] ar2:ar1) {
    			Arrays.fill(ar2, -1);
    		}
    	}
    	
    	return getMaxProfit(0, n, 0, 2, prices, dp);
    }
    
    
    public static void main(String[] args) {
		int[] prices ={3, 3, 5, 0, 0, 1, 4};
		
		long profit = maxProfit(prices);
		
		System.out.println(profit);
	}

}
