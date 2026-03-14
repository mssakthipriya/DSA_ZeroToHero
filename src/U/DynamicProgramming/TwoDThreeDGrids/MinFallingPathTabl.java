package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class MinFallingPathTabl {
	

	public static int getMinFallingSum(int[][] maze) {
		int n = maze.length;
		
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++) {
			dp[0][i] = maze[0][i];
		}
		for(int i=1;i<n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++) {
				if(j==0) {
					dp[i][j]= maze[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
				}else if(j==n-1) {
					dp[i][j]= maze[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
				}else {
					dp[i][j]= maze[i][j]+Math.min(Math.min(dp[i-1][j+1],dp[i-1][j-1]),dp[i-1][j]);
				}
			}
		}
		for(int[] row:dp) {
			System.out.println(Arrays.toString(row));
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			min = Math.min(min, dp[n-1][i]);
		}
		return min;
	}
	public static void main(String[] args) {
		int[][] maze = {{2,1,3},{6,5,4},{7,8,9}};
		
		int minSum = getMinFallingSum(maze);
		
		System.out.println(minSum);
	}

}
