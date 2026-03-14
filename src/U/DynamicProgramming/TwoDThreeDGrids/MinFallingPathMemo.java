package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class MinFallingPathMemo {
	
	public static int getMinSum(int[][] maze, int m, int n, int len,int[][] dp) {
		if(m<0 || n<0||n>=len) return (int)1e9;
		if(m==0) return maze[m][n];		
		
		if(m==0) return maze[m][n];
		if(dp[m][n]!=-1) return dp[m][n];
		
		int left =  maze[m][n]+getMinSum(maze, m-1, n-1,len,dp);
		int center = maze[m][n]+getMinSum(maze, m-1, n,len,dp);
		int right = maze[m][n]+getMinSum(maze, m-1, n+1,len,dp);
				
		return dp[m][n] = Math.min(left,Math.min(center, right));		
	}
	public static int getMinFallingSum(int[][] maze) {
		int m = maze.length;
		int n = maze[0].length;
		int dp[][] = new int[m][n];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			int sum = getMinSum(maze,m-1,i,n,dp);
			min = Math.min(min, sum);
		}
		
		
		return min;
	}
	public static void main(String[] args) {
		int[][] maze = {{2,1,3},{6,5,4},{7,8,9}};
		
		int minSum = getMinFallingSum(maze);
		
		System.out.println(minSum);
	}

}
