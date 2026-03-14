package U.DynamicProgramming.Subsequences;


public class CoinChangeIITabl {

    public static int change(int amt, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amt+1];
        
        for(int amount=0;amount<=amt;amount++) {
        	if(amount%coins[0]==0) {
        		dp[0][amount] = 1;
        	}
        }
        
        for(int ind = 1;ind<n;ind++) {
        	for(int amount=0;amount<=amt;amount++) {
                int notTake = dp[ind-1][amount];
                
                int take = 0;
                if(amount>=coins[ind]) {
                	take = dp[ind][amount-coins[ind]];
                }
                
                dp[ind][amount] = take+notTake;
        	}
        }
        
        return dp[n-1][amt];
    }
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		
		int ways = change(amount, coins);
		
		System.out.println(ways);
	}
}
