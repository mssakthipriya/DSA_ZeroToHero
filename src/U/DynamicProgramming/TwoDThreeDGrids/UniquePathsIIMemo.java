package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class UniquePathsIIMemo {
	public static int getPathCount(int[][] grid, int m, int n,int[][] dp) {
		if(m==0 && n==0) return grid[m][n]==1?0:1;
		if(m<0 || n<0) return 0;
		
		if(grid[m][n]==1) return 0;
		if(dp[m][n]!=-1) return dp[m][n];
		int up = getPathCount(grid, m-1, n, dp);
		int left = getPathCount(grid, m, n-1, dp);
		
		return dp[m][n]=up+left;
	}
	public static int getPathways(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		int count = getPathCount(grid,m-1,n-1,dp);
		
		return count;
	}
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int pathCount = getPathways(obstacleGrid);
		
		System.out.println(pathCount);
	}

}
