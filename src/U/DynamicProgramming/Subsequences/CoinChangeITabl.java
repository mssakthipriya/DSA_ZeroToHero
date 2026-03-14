package U.DynamicProgramming.Subsequences;



public class CoinChangeITabl {
	
	 public static int coinChange(int[] coins, int amt) {
		 int n = coins.length;
		 
		 int[][] dp = new int[n][amt+1];
		 
		 for(int i=0;i<=amt;i++) {
			 if(i%coins[0]==0) {
				 dp[0][i] = i/coins[0];
			 }else {
				 dp[0][i] =Integer.MAX_VALUE;
			 }
		 }
		 
		 for(int ind = 1; ind<n;ind++) {
			for(int amount = 0;amount<=amt;amount++) {
				int notTake = dp[ind-1][amount];
				
				int take = Integer.MAX_VALUE;
				
				if(amount>=coins[ind]) {
					take = 1+ dp[ind][amount-coins[ind]];
				}		
				
				dp[ind][amount] = Math.min(notTake, take);
			} 
		 }

		 
		 return dp[n-1][amt]==Integer.MAX_VALUE?-1:dp[n-1][amt];
	 }
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		
		int count = coinChange(coins, amount);
		
		System.out.println(count);
	}

}
