package U.DynamicProgramming.Subsequences;

public class ZeroOneKnapsackTabl {
	
	
	public static int zeroOneKnapSack(int w, int[] weight, int[] profit) {
		int n = weight.length;
		
		int[][] dp = new int[n][w+1];
		
		for(int i = weight[0];i<=w;i++) {
			dp[0][i] = profit[0];
		}
		
		for(int ind=1;ind<n;ind++) {
			for(int wt = 0;wt<=w;wt++) {
				int notTake = dp[ind-1][wt];
				int take = 0;
				if(weight[ind]<=wt) {
					take = profit[ind] + dp[ind-1][wt-weight[ind]];
				}
				
				dp[ind][wt] = Math.max(notTake, take);
			}
		}
		return dp[n-1][w];
	}
	public static void main(String[] args) {
		int w = 4;
		int[] profit = {1, 2, 3};
		int[] weight = {4, 5, 1};
		
		int value = zeroOneKnapSack(w,weight,profit);
		
		System.out.println(value);
	}

}
