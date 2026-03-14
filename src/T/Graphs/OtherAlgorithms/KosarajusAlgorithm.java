package T.Graphs.OtherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajusAlgorithm {
	public static void dfs(int start, int[] vis, List<List<Integer>> adj,Stack<Integer> st) {
		vis[start] = 1;
		
		for(int neighbour:adj.get(start)) {
			if(vis[neighbour]==0) {
				dfs(neighbour, vis, adj, st);
			}
		}
		st.push(start);
	}
	
	public static void dfs2(int start, int[] vis, List<List<Integer>> adj) {
		vis[start] = 1;
		
		for(int neighbour:adj.get(start)) {
			if(vis[neighbour]==0) {
				dfs2(neighbour, vis, adj);
			}
		}
	}
	public static int getSCC(int n, List<List<Integer>> adj) {
		int scc = 0;
		Stack<Integer> st = new Stack<>();
		int[] vis = new int[n];
		for(int i=0;i<n;i++) {
			if(vis[i]==0) {
				dfs(i, vis, adj, st);
			}
		}
		
		List<List<Integer>> adjT = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adjT.add(new ArrayList<>());
		}
		
		for(int i=0;i<n;i++) {
			for(int j : adj.get(i)) {
				adjT.get(j).add(i);
			}
		}
		Arrays.fill(vis, 0);
		
		while(!st.isEmpty()) {
			int start = st.pop();
			
			if(vis[start]==0) {
				scc++;
				dfs2(start, vis, adjT);
			}
		}
		
		
		return scc;
	}
	public static void main(String[] args) {
		int n = 5;	
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
            };
		List<List<Integer>> adj = new ArrayList<>();		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			adj.get(a).add(b);			
		}
		
		int scc = getSCC(n, adj);
		System.out.println(scc);		
		
	}

}
