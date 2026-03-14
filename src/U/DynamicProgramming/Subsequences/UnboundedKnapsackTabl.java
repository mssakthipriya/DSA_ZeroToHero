package U.DynamicProgramming.Subsequences;


public class UnboundedKnapsackTabl {
	
	 public static int unboundedKnapsack(int w, int[] weight, int[] profit) {
		 int n = weight.length;
		 
		 int[][] dp = new int[n][w+1];
		 
		 for(int i = weight[0];i<=w;i++) {
			 dp[0][i] = (i/weight[0])*profit[0];
		 }
		 
		 for(int ind=1;ind<n;ind++) {
			 for(int wt=0;wt<=w;wt++) {
					int notTake = dp[ind-1][wt];
					
					int take =0;
					if(weight[ind]<=wt) {
						take = profit[ind]+dp[ind][wt-weight[ind]];
					}
					
					dp[ind][wt] = Math.max(notTake, take);
			 }
		 }
		 
		 return dp[n-1][w];
	 }
	
	public static void main(String[] args) {
		int w = 8;
		int[] wt = {2, 4, 6};
		int[] val = {5, 11, 13};
		
		int total = unboundedKnapsack(w, wt, val);
		System.out.println(total);
	}

}
