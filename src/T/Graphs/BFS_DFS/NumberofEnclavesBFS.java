package T.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofEnclavesBFS {
	public static int getEnclaves(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		int[][] vis = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			if(vis[i][0]==0 && grid[i][0]==1) {
				q.add(new int[] {i,0});
			}
			if(vis[i][m-1]==0 && grid[i][m-1]==1) {
				q.add(new int[] {i,m-1});
			}
		}
		for(int j=0;j<m;j++) {
			if(vis[0][j]==0 && grid[0][j]==1) {
				q.add(new int[] {0,j});
			}
			if(vis[n-1][j]==0 && grid[n-1][j]==1) {
				q.add(new int[] {n-1,j});
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			int[] pair = q.poll();
			int x=pair[0];
			int y = pair[1];
			vis[x][y] = 1;
			for(int i=0;i<4;i++) {
				int xi = x+dx[i];
				int yi = y+dy[i];
				if(xi>=0 && yi>=0 && xi<n && yi <m && vis[xi][yi]==0 && grid[xi][yi]==1) {
					vis[xi][yi]=1;
				}
			}

		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(vis[i][j]==0 && grid[i][j]==1) {
					ans++;
				}
			}
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		//int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
		int ans = getEnclaves(grid);
		
		System.out.println(ans);
	}

}
