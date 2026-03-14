package U.DynamicProgramming.Subsequences;


public class CutRodTabl {
	
	public static int rodCutting(int[] price, int n) {
		
		int[][] dp = new int[n][n+1];
		
		for(int i=0;i<=n;i++) {
			dp[0][i] = price[0]*i;
		}
		
		for(int ind=1;ind<n;ind++) {
			for(int length = 0;length<=n;length++) {
				int notTake = dp[ind-1][length];
				
				int take = 0;
				int rodLen = ind+1;
				if(rodLen<=length) {
					take = price[ind]+dp[ind][length-rodLen];
				}
				
				dp[ind][length] = Math.max(notTake, take);
			}
		}
		
		return dp[n-1][n]	;	
	}
	public static void main(String[] args) {
		int[] price = {1, 6, 8, 9, 10, 19, 7, 20};
		int n = 8;
		
		int cost = rodCutting(price, n);
		
		System.out.println(cost);
	}

}
