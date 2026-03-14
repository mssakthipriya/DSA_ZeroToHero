package T.Graphs.ShortestPath;

import java.util.Arrays;

public class FloydWarshell {
	public static int[][] getShortestPaths(int[][] matrix){
		int n = matrix.length;
		int[][] shortestPaths = matrix;
		
		for(int k=0;k<n;k++) {
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
					if(shortestPaths[i][k]==-1|| shortestPaths[k][j]==-1) continue;
					
					if(shortestPaths[i][k]+shortestPaths[k][j]<shortestPaths[i][j] || shortestPaths[i][j]==-1) {
						shortestPaths[i][j] = shortestPaths[i][k]+shortestPaths[k][j];
					}
				}
			}
		}
		
		
		return shortestPaths;
	}
	public static void main(String[] args) {
		int[][] matrix = {{0, 2, -1, -1},{1, 0, 3, -1},{-1, -1, 0, 1},{3, 5, 4, 0}};
		
		int[][] shortestPaths = getShortestPaths(matrix);
		
		for(int[] d : shortestPaths) {
			System.out.println(Arrays.toString(d));
		}
	}

}
