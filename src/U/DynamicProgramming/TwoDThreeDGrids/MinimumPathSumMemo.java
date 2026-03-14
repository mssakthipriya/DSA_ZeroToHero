package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class MinimumPathSumMemo {
	public static int getSum(int[][] grid, int m, int n,int[][] dp) {
		if(m==0 && n==0) return grid[m][n];
		if(m<0||n<0) return  404;//404 not found or just put anylarge value that is grated than the limit 0 <= grid[i][j] <= 200 and not Integer.MAX
		
		if(dp[m][n]!=-1) return dp[m][n];
		
		int left = grid[m][n]+getSum(grid, m, n-1,dp);
		int up = grid[m][n]+getSum(grid, m-1, n,dp);
		
		return dp[m][n]=Math.min(left, up);
	}
	public static int getMinPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		int sum = getSum(grid, m-1, n-1,dp);
		
		return sum;
	}
	
	public static void main(String[] args) {
		//int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		  int[][] grid = {{1,2,3},{4,5,6}};
		int minPathSum = getMinPathSum(grid);
		
		System.out.println(minPathSum);
	}

}
