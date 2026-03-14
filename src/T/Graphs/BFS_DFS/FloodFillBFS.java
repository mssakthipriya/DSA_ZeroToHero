package T.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillBFS {

	public static int[][] floodfill(int[][] grid, int sr,int sc, int color){
		int[][] ans = grid;
		int initColor = ans[sr][sc];
		
		if(initColor==color) return ans;
		
		int[] row = {0,0,-1,1};
		int[] col = {-1,1,0,0};
		
		Queue<int[]> que = new LinkedList<>();
		
		que.offer(new int[] {sr,sc});
		ans[sr][sc] = color;
		
		while(!que.isEmpty()) {
			int[] sqr = que.poll();
			int x = sqr[0];
			int y = sqr[1];
			int m = ans.length;
			int n = ans[0].length;
			for(int i=0;i<4;i++) {
				int nx = x+row[i];
				int ny = y+col[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m && ans[nx][ny]==initColor) {
					ans[nx][ny] = color;
					que.offer(new int[] {nx,ny});
				}
			}
		}
		
		
		
		return ans;
	}
	public static void main(String[] args) {
		int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1;
		int sc = 1;
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
