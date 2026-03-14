package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
	public static boolean isValid(int row, int col, int n, int m) {
		return row>=0 && col>=0 && row<n && col<m;
	}
	public static List<Integer> getIslandCount(int n,int m,int[][] edges){
		List<Integer> ans = new ArrayList<>();
		int[][] vis = new int[n][m];
		DisjointSet dj = new DisjointSet(n*m);
		int cnt = 0;
		for(int[] edg : edges) {
			int row = edg[0];
			int col = edg[1];
			if(vis[row][col]==1) {
				ans.add(cnt);
				continue;
			}
			vis[row][col] = 1;
			cnt++;
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,1,-1};
			
			for(int i=0;i<4;i++) {
				int adjr = row+dx[i];
				int adjc = col+dy[i];
				if(isValid(adjr, adjc, n, m) && vis[adjr][adjc]==1) {
					int node = row*m+col;
					int adjNode = adjr*m+adjc;
					if(dj.findUParent(node)!=dj.findUParent(adjNode)) {
						cnt--;
						dj.unionbySize(node, adjNode);
					}
				}
			}
			ans.add(cnt);
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int n = 4, m = 5;
		int[][] edges= {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}};
		List<Integer> ans = getIslandCount(n,m,edges);
		
		System.out.println(ans.toString());
	}

}
