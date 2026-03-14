package T.Graphs.OtherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {
	private static int incr = 0;
	public static void dfs(int start,int parent,int[] vis,int[] tim,int[] low,List<List<Integer>> adj, List<Integer> path,List<List<Integer>> bridges) {
		vis[start] = 1;
		tim[start] = low[start] = incr++;
		path.add(start);
		
		for(int neighbour : adj.get(start)) {
			if(neighbour==parent) continue;
			if(vis[neighbour]!=1) {
				dfs(neighbour, start, vis, tim, low, adj, path, bridges);
				low[start] = Math.min(low[start], low[neighbour]);
				if(tim[start]<low[neighbour]) {
					bridges.add(Arrays.asList(start,neighbour));
				}
			}else {
				low[start] = Math.min(low[start], low[neighbour]);
			}			
		}
	}
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> adj) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] vis = new int[n];
        int[] tim = new int[n];
        int[] low = new int[n];
        
        dfs(4,-1, vis, tim, low, adj, path,bridges);
        System.out.println(path.toString());
        
        return bridges;
    }
	public static void main(String[] args) {
		int n = 15;	
		int[][] edges = {{0,1},{0,2},{1,2},{1,3},{1,5},{2,4},{2,6},{2,7},{3,4},{4,5},{5,6},
						 {7,8},{7,9},{8,9},{8,10},{9,11},{10,11},{10,12},{12,13},{12,14},{13,14}};
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
		
		List<List<Integer>> ans = criticalConnections(n,adj);
		
		for(List<Integer> conn : ans) {
			System.out.println(conn.toString());
		}
		
		
		
	}

}
