package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
	public static int getMinSpanningTree(int v, List<List<int[]>> adj, List<int[]> minSet) {
		int sum=0;
		
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int[] vis = new int[v];
		
		q.add(new int[] {0,0,-1});
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			int wt = point[0];
			int node = point[1];
			int parent = point[2];
			
			if(vis[node]==1) continue;
			
			vis[node] = 1;
			sum+=wt;
			if(parent!=-1) {
				minSet.add(new int[] {parent,node});
			}
			
			for(int[] p : adj.get(node)) {
				int adjNode = p[0];
				int adjWt = p[1];
				if(vis[adjNode]==0) {
					q.add(new int[] {adjWt,adjNode,node});
				}
			}
			
		}
		
		return sum;
	}
	public static void main(String[] args) {
		int v = 5;
		int[][] edges = { {0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
		
		List<List<int[]>> adj = new ArrayList<>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			int wt = edges[i][2];
			
			adj.get(a).add(new int[] {b,wt});
			adj.get(b).add(new int[] {a,wt});
		}
		
		List<int[]> minset = new ArrayList<>();
		
		int sum = getMinSpanningTree(v,adj,minset);
		
		for(int[] set: minset) {
			System.out.print(Arrays.toString(set)+",");
		}
		System.out.println();
		
		System.out.println(sum);
	}

}
