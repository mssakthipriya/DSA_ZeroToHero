package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class UniquePathsMemo {
	public static int getPathCount(int[][] maze,int m,int n) {
		if(m==0 && n==0) return 1;
		if(m<0 || n<0) return 0;
		
		if(maze[m][n]!=-1)return maze[m][n];
		
		int up = getPathCount(maze,m-1,n);
		int left = getPathCount(maze,m,n-1);
		
		return maze[m][n]=up+left;
	}
	public static int getUniquePaths(int m,int n) {
		int[][] maze = new int[m][n];
		for(int[] row: maze) {
			Arrays.fill(row, -1);
		}
		int count = getPathCount(maze,m-1,n-1);
		
		return count;		
	}
	
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		int count = getUniquePaths(m,n);
		
		System.out.println(count);
	}

}
