package T.Graphs.OtherAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticulationPoints {
	private static int incr = 0;
	public static void dfs(int start,int parent,int[] vis,int[] dtm,int[] low,List<List<Integer>> adj,Set<Integer> points) {
		vis[start] = 1;
		dtm[start] = low[start] = incr++;
		int children = 0;
		for(int neighbour : adj.get(start)) {
			if(neighbour==parent) continue;
			if(vis[neighbour]==0) {
				dfs(neighbour,start,vis,dtm,low, adj,points);
				low[start] = Math.min(low[start], low[neighbour]);
				if(low[neighbour]>=dtm[start] && parent!=-1) {
					points.add(start);
				}
				children++;
			}else {
				low[start] = Math.min(low[start], dtm[neighbour]);
			}
		}
		if(parent==-1 && children>1) {
			points.add(start);
		}
	}
	public static List<Integer> articulationPoints(int n,List<List<Integer>> adj){
		Set<Integer> points = new HashSet<>();
		int[] vis = new int[n];
		int[] dtm = new int[n];
		int[] low = new int[n];
		
		for(int i=0;i<n;i++) {
			if(vis[i]==0) {
				dfs(i, -1, vis, dtm, low, adj,points);
			}

		}
		List<Integer> artPoints = new ArrayList<Integer>(points);
		return artPoints;
	}
	public static void main(String[] args) {
		int n = 5;	
		int[][] edges = {{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
		List<List<Integer>> adj = new ArrayList<>();		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		List<Integer> ans = articulationPoints(n,adj);
		
		System.out.println(ans.toString());
	}

}
