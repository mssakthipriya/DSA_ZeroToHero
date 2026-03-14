package T.Graphs.BFS_DFS;

public class FloodFillDFS {
	public static void dfs(int[][] ans,int sr, int sc, int initColor, int newColor, int[] row,int[] col) {
		ans[sr][sc] = newColor;
		int m = ans.length;
		int n = ans[0].length;
		for(int i=0;i<4;i++) {
			int nRow = sr+row[i];
			int nCol = sc+col[i];
			if(nRow>=0 && nCol>=0 && nRow<m && nCol<n && ans[nRow][nCol]==initColor && ans[nRow][nCol]!=newColor) {
				dfs(ans,nRow,nCol,initColor,newColor,row,col);
			}
		}
	}
	public static int[][] floodfill(int[][] grid, int sr,int sc, int color){
		int[][] ans = grid;
		int initColor = ans[sr][sc];
		
		int[] row = {0,0,-1,1};
		int[] col = {-1,1,0,0};
		
		dfs(ans,sr,sc,initColor,color,row,col);
		
		return ans;
	}
	public static void main(String[] args) {
		int[][] grid = {{1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		int sr = 1;
		int sc = 2;
		int color = 2;
		
		int[][] ans = floodfill(grid,sr,sc,color);
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}

	}

}
