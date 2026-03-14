package T.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	
	public static int[][] updateGrid(int[][] grid){
		int n = grid.length;
		int m = grid[0].length;
		
		int[][] vis = new int[n][m];
		int[][] ans = new int[n][m];
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j]==1) {
					q.add(new int[] {i,j,0});
					vis[i][j]=1;
				}
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			int[] cell = q.poll();
			int x = cell[0];
			int y = cell[1];
			int step = cell[2];
			
			ans[x][y] = step;
			
			for(int i=0;i<4;i++) {
				int xi = x+dx[i];
				int yi = y+dy[i];
				if(xi>=0 && yi>=0 && xi<n && yi<m && vis[xi][yi]==0) {
					q.add(new int[] {xi,yi,step+1});
					vis[xi][yi]=1;
				}	
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[][] grid = {{1,0,1},{1,1,0},{1,0,0}};
		
		int[][] ans = updateGrid(grid);
		
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
