package T.Graphs.ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistBinMaze2 {
	
	public static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
		
		int[][] dist = new int[m][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i],Integer.MAX_VALUE);
		}
		dist[0][0]=1;
		int[] dx = {-1,1,0,0,-1,1,-1,1};
		int[] dy = {0,0,1,-1,1,1,-1,-1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int d = point[2];
			
			for(int i=0;i<8;i++) {
				int xi = x+dx[i];
				int yi = y+dy[i];
				
				if(xi>=0 && yi>=0 && xi<n && yi<m && grid[xi][yi]==0 && d+1 < dist[xi][yi]) {
					dist[xi][yi]=d+1;
					if(xi==n-1 && yi==m-1) {
						return dist[xi][yi];
					}
					
					q.add(new int[] {xi,yi,d+1});
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int[][] grid = {{0, 0, 0},  
                		{1, 1, 0},  
                		{1, 1, 0}}  ;
		

		int steps = shortestPathBinaryMatrix(grid);
		
		System.out.println(steps);
		
	}

}
