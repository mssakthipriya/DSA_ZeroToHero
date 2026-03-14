package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class MatrixChainMaultiplicationMemo {
	public static int solve(int i, int j,int[] arr, int[][] dp) {
		if(i==j) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int cost1 = solve(i, k, arr, dp);
			int cost2 = solve(k+1, j, arr, dp);
			int costMultiply = arr[i-1]*arr[k]*arr[j];
			min = Math.min(min, cost1+cost2+costMultiply);
		}
		
		return dp[i][j]=min;
	}
	 public static int matrixChainOrder(int[] arr) {
		 int n = arr.length;
		 
		 int[][] dp = new int[n][n];
		 
		 for(int[] ar:dp) {
			 Arrays.fill(ar, -1);
		 }

		 return solve(1, n-1, arr, dp);
	 }
	
	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10, 30};
		
		int steps = matrixChainOrder(arr);
		
		System.out.println(steps);
	}

}
