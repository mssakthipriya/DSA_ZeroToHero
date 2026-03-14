package U.DynamicProgramming.stocks;

public class BestTimeForStockCoolDownMemo {
	
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0) return 0;
        
        int[][] dp = new int[n+2][2];
        
        for(int i = n-1;i>=0;i--) {
        	for(int buy = 0; buy<=1;buy++) {
        		int profit = 0;
        		
        		if(buy==0) {
        			profit = Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
        		}else {
        			profit = Math.max(prices[i]+dp[i+2][0],dp[i+1][1]);
        		}
        		
        		dp[i][buy] = profit;
        	}
        }
        
        return dp[0][0];
    }
	
	public static void main(String[] args) {
		int[] prices = {4,9, 0, 4, 10};
		
		int profit = maxProfit(prices);
		
		System.out.println(profit);
	}
}
