package T.Graphs.BFS_DFS;

public class IslandCount {
	public static void dfs(int[][] grid,int[][] vis, int x, int y,int[] dx, int[] dy) {
		int n = grid.length;
		int m = grid[0].length;
		
		vis[x][y] = 1;
		
		for(int i=0;i<8;i++) {
			int xi = x+dx[i];
			int yi = y+dy[i];
			
			if(xi>=0 && yi>=0 && xi<n && yi<m && vis[xi][yi]==0 && grid[xi][yi]==1) {
				dfs(grid,vis,xi,yi,dx,dy);
			}
		}

		
	}
	public static int getIslandCount(int[][] grid) {
		int count = 0;
		int n = grid.length;
		int m = grid[0].length;
		int[] dx = {-1,1,0,0,-1,-1,1,1};
		int[] dy = {0,0,1,-1,-1,1,-1,1};
		int[][] vis = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(vis[i][j] == 0 && grid[i][j]==1) {
					count++;
					dfs(grid,vis,i,j,dx,dy);
				}
			}
		}
		
		
		return count;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,1,0},{0,1,1,0},{0,0,0,1},{0,0,0,0},{1,1,0,1}};
		
		int count = getIslandCount(grid);
		
		System.out.println(count);
	}

}
