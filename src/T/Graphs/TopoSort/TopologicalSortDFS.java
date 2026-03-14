package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class TopologicalSortDFS {
	
	public static void dfs(int start,List<List<Integer>> adj, int[] vis, Stack<Integer> st) {
		vis[start] = 1;
		
		for(int neighbour : adj.get(start)) {
			
			if(vis[neighbour]==0) {
				dfs(neighbour, adj, vis, st);
			}
		}
		st.push(start);
	}
	public static List<Integer> getTopoOrder(int v, List<List<Integer>> adj ){
		List<Integer> ans = new ArrayList<>();
		
		int[] vis = new int[v];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<v;i++) {
			if(vis[i]==0) {
				dfs(i,adj,vis,st);
			}
		}
		
		while(!st.isEmpty()) {
			ans.add(st.pop());
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int v = 6;
		//{{},{3},{3},{},{0,1},{0,2}}
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(1).addAll(Arrays.asList(3));
		adj.get(2).addAll(Arrays.asList(3));
		adj.get(4).addAll(Arrays.asList(0,1));
		adj.get(5).addAll(Arrays.asList(0,2));
		
		List<Integer> ans = getTopoOrder(v,adj);
		
		System.out.println(ans.toString());
		
	}

}
