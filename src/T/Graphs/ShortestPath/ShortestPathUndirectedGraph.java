package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
	
	public static int[] getShortestPath(int n,int src, int[][] edges) {
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
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

		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		dist[src] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int neighbour:adj.get(node)) {

				if(dist[neighbour]>dist[node]+1) {
					dist[neighbour] = dist[node]+1;
					q.add(neighbour);
				}
			}
			
		}
		
		for(int i=0;i<n;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				dist[i]=-1;
			}
		}
			
		
		return dist;
	}
	public static void main(String[] args) {
		int n = 9;
		int src = 0;
		int[][] edges = {{0,1},{0,3},{3,4},{4 ,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
		
		int[] dist = getShortestPath(n,src,edges);
		
		System.out.println(Arrays.toString(dist));
	}

}
