package T.Graphs.BFS_DFS;

public class NumberofEnclaves {
	public static void dfs(int[][] grid,int[][] vis,int r, int c,int[] dr,int[] dc) {
		vis[r][c]=1;
		int n = grid.length;
		int m = grid[0].length;

		for(int i=0;i<4;i++) {
			int rx = r+dr[i];
			int cy = c+dc[i];
			if(rx>=0 && cy>=0 && rx<n && cy<m && vis[rx][cy]==0 && grid[rx][cy]==1) {
				dfs(grid, vis, rx, cy, dr, dc);
			}
		}
	}
	public static int getEnclaves(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		
		int [][] vis = new int[n][m];
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,1,-1};		
		for(int i=0;i<n;i++) {
			if(vis[i][0]==0 && grid[i][0]==1) {
				dfs(grid, vis, i, 0, dc, dr);
			}
			if(vis[i][m-1]==0 && grid[i][m-1]==1) {
				dfs(grid, vis, i, m-1, dc, dr);
			}
		}
		
		for(int j=0;j<m;j++) {
			if(vis[0][j]==0 && grid[0][j]==1) {
				dfs(grid, vis, 0, j, dr, dc);
			}
			if(vis[n-1][j]==0 && grid[n-1][j]==1) {
				dfs(grid, vis, n-1, j, dr, dc);
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
