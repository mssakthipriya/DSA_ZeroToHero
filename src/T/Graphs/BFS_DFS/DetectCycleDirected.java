package T.Graphs.BFS_DFS;

import java.util.ArrayList;

public class DetectCycleDirected {
	public static boolean dfs(int start,ArrayList<ArrayList<Integer>> adj,int[] vis,int[] pathVis) {
		vis[start] = 1;
		pathVis[start] = 1;
		
		for(int neighbour : adj.get(start)) {
			if(vis[neighbour]==0) {
				if(dfs(neighbour, adj, vis, pathVis)==true) return true;
			}else if(pathVis[neighbour]==1) {
				return true;
			}
		}
		pathVis[start] = 0;
		
		return false;
	}
	public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
		
		int[] vis = new int[v];
		int[] pathVis = new int[v];
		
		for(int i=0;i<v;i++) {
			if(vis[i]==0) {
				if(dfs(i,adj,vis,pathVis)== true) return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
        int v = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        
        boolean check = isCycle(v,adj);
        
        System.out.println(check);

	}

}
