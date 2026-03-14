package T.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesBFS {

	public static int orangesRotting(int[][] grid) {
		if(grid==null||grid.length==0) return 0;
		
		int row = grid.length;
		int col = grid[0].length;
		int count_oranges = 0;		
		Queue<int []> que = new LinkedList<>();
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(grid[i][j]==2) {
					que.offer(new int[] {i,j});
				}
				if(grid[i][j]!=0) {
					count_oranges++;
				}
			}
		}
		
		if(count_oranges==0) return 0;
		int min_count = 0,count = 0;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!que.isEmpty()) {
			int size = que.size();
			count+=size;
			
			for(int i=0;i<size;i++) {
				int[] point = que.poll();
				for(int j=0;j<4;j++) {
					int x = point[0]+dx[j];
					int y = point[1]+dy[j];
					
					if(x<0||x>=row||y<0||y>=col||grid[x][y]==0||grid[x][y]==2) continue;
					
					grid[x][y]=2;
					que.offer(new int[] {x,y});
				}
			}
			
			if(que.size()!=0) min_count++;
		}
		
		return count==count_oranges?min_count:-1;
	}
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		int time = orangesRotting(grid);
		
		System.out.println(time);
	}
}
