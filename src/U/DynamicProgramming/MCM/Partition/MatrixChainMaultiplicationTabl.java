package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class MatrixChainMaultiplicationTabl {
	 public static int matrixChainOrder(int[] arr) {
		 int n = arr.length;
		 
		 int[][] dp = new int[n][n];

		 for(int i=0;i<n;i++) {
			 dp[i][i] = 0;
		 }
		 
		  for(int i=n-1;i>=1;i--) {
			  for(int j=i+1;j<n;j++) {
				  int min = Integer.MAX_VALUE;
				  for(int k=i;k<j;k++) {
					  int steps = dp[i][k]+dp[k+1][j]+(arr[i-1]*arr[k]*arr[j]);
					  if(steps<min) {
						  min = steps;
					  }
				  }
				  dp[i][j] = min;
			  }
		  }
		 

		 for(int[] ar:dp) {
			 System.out.println(Arrays.toString(ar));
		 }

		 return dp[1][n-1];
	 }
	
	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10, 30};
		
		int steps = matrixChainOrder(arr);
		
		System.out.println(steps);
	}
}
