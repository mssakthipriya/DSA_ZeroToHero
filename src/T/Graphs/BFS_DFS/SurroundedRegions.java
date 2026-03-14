package T.Graphs.BFS_DFS;

public class SurroundedRegions {
	public static void dfs(char[][] grid,int[][] vis,int r,int c,int[] dr, int[] dc) {
		vis[r][c] = 1;
		int n = grid.length;
		int m = grid[0].length;
		for(int i=0;i<4;i++) {
			int rx = r+dr[i];
			int cy = c+dc[i];
			
			if(rx>=0 && cy >=0 && rx< n && cy <m && vis[r][c]==0 && grid[r][c]=='X') {
				dfs(grid, vis, rx, cy, dr, dc);
			}
		}
	}
	public static char[][] getSurroundedReg(char[][] grid){
		int n = grid.length;
		int m = grid[0].length;
		char[][] ans = new char[n][m];
		int[][] vis = new int[n][m];
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,1,-1};
		for(int i=0;i<n;i++) {
			if(grid[i][0]=='O' && vis[i][0]==0) {
				dfs(grid,vis,i,0,dr,dc);
			}
			if(grid[i][m-1]=='O' && vis[i][m-1]==0) {
				dfs(grid,vis,i,m-1,dr,dc);
			}
		}
		for(int j=0;j<m;j++) {
			if(grid[0][j]=='O' && vis[0][j]==0) {
				dfs(grid,vis,0,j,dr,dc);
			}
			if(grid[n-1][j]=='O' && vis[n-1][j]==0) {
				dfs(grid,vis,n-1,j,dr,dc);
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(vis[i][j]==0 && grid[i][j]=='O') {
					grid[i][j]='X';
				}
			}
		}
		return grid;
	}
	
	public static void main(String[] args) {
		char[][] grid = {{'X','X','X','X'},{'X','O','X','X'},{'X','O','O','X'},{'X','O','X','X'},{'X','X','O','O'}};
		char[][] ans = getSurroundedReg(grid);
		
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}
