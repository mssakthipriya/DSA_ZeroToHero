package T.Graphs.ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistBinMaze {
	
	public static int getSteps(int[][] grid, int[] source, int[] destination) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dist =new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {source[0],source[1],0});
		dist[source[0]][source[1]] = 0;
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int d = point[2];
			
			for(int i=0;i<4;i++) {
				int xi = x+dx[i];
				int yi = y+dy[i];
				
				if(xi>=0 && yi>=0 && xi<n && yi<m && grid[xi][yi]==1 && d+1<dist[xi][yi]) {
					dist[xi][yi]=d+1;
					
					if(xi==destination[0] && yi==destination[1]) {
						return dist[xi][yi];
					}
					
					q.add(new int[] {xi,yi,d+1});
				}
			}
		}
		
		
		
		return -1;
	}
	public static void main(String[] args) {
		int[][] grid = {{1, 1, 1, 1},  
                		{1, 1, 0, 1},  
                		{1, 1, 1, 1},  
                		{1, 1, 0, 0},  
                		{1, 0, 0, 1}}  ;
		
		 int[] source = {0, 1};
	     int[] destination = {2, 2};
		
		int steps = getSteps(grid,source,destination);
		
		System.out.println(steps);
	}

}
