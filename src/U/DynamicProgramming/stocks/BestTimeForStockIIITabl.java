package U.DynamicProgramming.stocks;


public class BestTimeForStockIIITabl {
	
    public static long maxProfit(int[] prices) {
        
    	int n = prices.length;
    	if(n==0) return 0;
    	
    	long[][][] dp = new long[n+1][2][3];    	
   	
    	for(int i=n-1;i>=0;i--) {
    		for(int buy = 0;buy<=1;buy++) {
    			for(int cap = 1;cap<=2;cap++) {
    				long profit = 0;
    				if(buy == 0) {
    					profit = Math.max(-prices[i]+dp[i+1][1][cap], dp[i+1][0][cap]);
    				}else {
    					profit = Math.max(prices[i]+dp[i+1][0][cap-1], dp[i+1][1][cap]);
    				}
    				
    				dp[i][buy][cap] = profit;
    			}
    		}
    	}
    	
    	return dp[0][0][2];
    }
	public static void main(String[] args) {
		int[] prices ={3, 3, 5, 0, 0, 1, 4};
		
		long profit = maxProfit(prices);
		
		System.out.println(profit);
	}

}
