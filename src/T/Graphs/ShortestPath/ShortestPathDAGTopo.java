package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAGTopo {
	
	public static void dfs(int n, int start, List<List<int[]>> adj,int[] vis,Stack<Integer> st) {
		vis[start] = 1;
		for(int[] pair : adj.get(start)) {
			int adjNode = pair[0];
			if(vis[adjNode]!=1) {
				dfs(n, adjNode, adj, vis, st);				
			}
		}
		st.push(start);
	}
	public static int[] getShortestDist(int n, int[][] edges) {
		int[] vis = new int[n];

		List<List<int[]>> adj = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			int wt = edges[i][2];
			adj.get(a).add(new int[] {b,wt});
		}
		int src = 0;			
		for(int i=0;i<n;i++) {
			if(vis[i]!=1) {
				dfs(n, src, adj, vis,st);
			}
		}
				
		
		int[] dist = new int[n];
		Arrays.fill(dist, (int)1e9);
		
		dist[0] = 0;

		while(!st.isEmpty()) {
			int node = st.pop();
			
			for(int[] neighbour: adj.get(node)) {
				int adjNode = neighbour[0];
				int wt = neighbour[1];
				
				if(dist[node]+wt <dist[adjNode]) {
					dist[adjNode] = dist[node]+wt;
				}
				
			}
			
		}
		
		for(int i=0;i<n;i++) {
			if(dist[i]==(int)1e9) {
				dist[i]=-1;
			}
		}
		
		
		return dist;
	}
	public static void main(String[] args) {
		int n = 7;
		int[][] edges = {{0,4,2},{0,5,3},{5,4,1},{4,6,3},{4,2,1},{6,1,2},{2,3,3},{1,3,1}};
		
		int[] dist = getShortestDist(n,edges);
		
		System.out.println(Arrays.toString(dist));
	}

}
