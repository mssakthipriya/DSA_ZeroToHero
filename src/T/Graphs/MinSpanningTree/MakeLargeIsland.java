package T.Graphs.MinSpanningTree;

import java.util.HashSet;
import java.util.Set;

public class MakeLargeIsland {
	public static boolean isValid(int row,int col,int n) {
		return row>=0 && row<n &&col>=0 && col<n;
	}
	//step 1
	public static int getIslandSize(int[][] grid) {
		int n = grid.length;
		DisjointSet dj = new DisjointSet(n*n);
		for(int row = 0;row<n;row++) {
			for(int col = 0;col<n;col++) {
				if(grid[row][col]==0) continue;
				int[] dr = {-1,1,0,0};
				int[] dc = {0,0,1,-1};
				
				for(int i=0;i<4;i++) {
					int newr = row+dr[i];
					int newc = col+dc[i];
					if(isValid(newr,newc,n) && grid[newr][newc]==1) {
						int node = row*n+col;
						int adjNode = newr*n+newc;
						dj.unionbySize(node, adjNode);
					}
				}
				
			}
		}
		//step 2
		int size=0;
		for(int row = 0; row<n; row++) {
			for(int col = 0; col<n; col++) {
				if(grid[row][col]==1) continue;
				int[] dr = {-1,1,0,0};
				int[] dc = {0,0,1,-1};
				Set<Integer> components = new HashSet<>();
				for(int i=0;i<4;i++) {
					int newr = row+dr[i];
					int newc = col+dc[i];
					if(isValid(newr,newc,n) && grid[newr][newc]==1) {
						int adjNode = newr*n+newc;
						components.add(dj.findUParent(adjNode));
					}
				}
				
				int tot = 0;
				for(int it : components) {
					tot+=dj.getSize(it);
				}
				size = Math.max(size, tot+1);
			}
		}
		
		for(int cell = 0 ;cell<n*n;cell++) {
			size = Math.max(size, dj.getSize(dj.findUParent(cell)));
		}
		
		
		return size;
	}
	public static void main(String[] args) {
		int[][] grid = {{1,1},{1,0}};
		int islandSize = getIslandSize(grid);
		System.out.println(islandSize);
	}
}
