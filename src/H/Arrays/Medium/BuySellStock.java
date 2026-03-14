package H.Arrays.Medium;

public class BuySellStock {
	
	public static int getMaxProfitII(int[] prices) {
		int max = 0;
		int minPrice = Integer.MAX_VALUE;
		for(int j=0;j<prices.length;j++) {
			minPrice = Math.min(minPrice, prices[j]);
			max = Math.max(max, prices[j]-minPrice);
		}
		return max;
	}
	
	public static int getMaxProfit(int[] prices) {
		int max = 0;
		int profit = 0;
		int i=0;
		for(int j=0;j<prices.length;j++) {
			if(prices[i]>prices[j]) {
				i=j;
			}else {
				profit = prices[j]-prices[i];
				max = Math.max(max, profit);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {7,1,5,3,6,4};
		
		System.out.println("The maximum profit that can be obtained is:"+getMaxProfit(arr));
		System.out.println("II way: The maximum profit that can be obtained is:"+getMaxProfitII(arr));
	}
}
