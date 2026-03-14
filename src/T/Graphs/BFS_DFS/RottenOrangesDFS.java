package T.Graphs.BFS_DFS;

import java.util.Arrays;

public class RottenOrangesDFS {

	public static void dfs(int[][] grid,int[][] time,int i,int j,int currentTime) {
		if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||currentTime>=time[i][j])return;
		time[i][j] = currentTime;
		dfs(grid,time,i+1,j,currentTime+1);
		dfs(grid,time,i,j+1,currentTime+1);
		dfs(grid,time,i-1,j,currentTime+1);
		dfs(grid,time,i,j-1,currentTime+1);
	}
	public static int orangesRotting(int[][] grid) {
		if(grid==null || grid.length==0)  return -1;
		int row = grid.length;
		int col = grid[0].length;
		int[][] time = new int[row][col];
		for(int i=0;i<row;i++) {
			Arrays.fill(time[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(grid[i][j]==2) {
					dfs(grid,time,i,j,0);
				}
			}
		}
		int reqTime = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(grid[i][j]==1) {
					if(time[i][j]==Integer.MAX_VALUE) return -1;
					reqTime = Math.max(reqTime, time[i][j]);
				}
			}
		}
		
		
		return reqTime;
	}
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		int time = orangesRotting(grid);
		
		System.out.println(time);
	}
}
