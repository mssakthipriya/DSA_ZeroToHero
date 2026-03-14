package U.DynamicProgramming.stocks;



public class BestTimeForStockIVTabl {

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
    	if(n==0) return 0;
    	
    	int[][][] dp = new int[n+1][2][k+1];
    	
    	for(int i = n-1;i>=0;i--) {
    		for(int buy = 0;buy<=1;buy++) {
    			for(int cap = 1;cap<=k;cap++) {
    		    	int profit = 0;
    		    	if(buy==0) {
    		    		profit = Math.max(-prices[i]+dp[i+1][1][cap], dp[i+1][0][cap]);
    		    	}else {
    		    		profit = Math.max(prices[i]+dp[i+1][0][cap-1], dp[i+1][1][cap]);
    		    	}
    		    	
    		    	dp[i][buy][cap] = profit;
    			}
    		}
    	}
    	
    	return dp[0][0][k];
    }
	public static void main(String[] args) {
		int k = 2;
		int[] prices = {3,2,6,5,0,3};
		
		int profit = maxProfit(k, prices);
		
		System.out.println(profit);
	}

}
