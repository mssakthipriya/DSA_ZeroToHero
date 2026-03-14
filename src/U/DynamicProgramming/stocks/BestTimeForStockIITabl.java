package U.DynamicProgramming.stocks;

public class BestTimeForStockIITabl {

	public static long maxProfit(int[] prices) {
		int n = prices.length;
		
		long dp[][] = new long[n+1][2];
		
		for(int index=n-1;index>=0;index--) {
			for(int buy = 0;buy<2;buy++) {
				
				long profit = 0;
				if(buy==0) {
					profit = Math.max(-prices[index]+dp[index+1][1], dp[index+1][0]);
				}else {
					profit = Math.max(prices[index]+dp[index+1][0], dp[index+1][1]);
				}
				
				dp[index][buy] = profit;
			}			

		}
			
		return dp[0][0];
	}
	public static void main(String[] args) {
		 int[] stocks={7, 1, 5, 3, 6, 4};
		 
		 long profit = maxProfit(stocks);
		 
		 System.out.println(profit);
	}
}
