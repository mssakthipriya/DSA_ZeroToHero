package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasPQ {
	
	
	public static int[] getShortest(int v,int src, List<List<int[]>> adj) {
		int[] dist = new int[v];
		Arrays.fill(dist,(int)1e9);
		
		dist[0]=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		
		pq.add(new int[] {src,0});
		
		while(!pq.isEmpty()) {
			int[] pair = pq.poll();
			int node = pair[0];
			int d = pair[1];
			
			if(d>dist[node]) continue;
			
			for(int[] p :adj.get(node)) {
				int adjNode = p[0];
				int wt = p[1];
				if(dist[node]+wt<dist[adjNode]) {
					dist[adjNode] = dist[node]+wt;
					pq.add(new int[] {adjNode,dist[adjNode]});
				}
			}
		}
		
		
		return dist;
	}
	public static void main(String[] args) {
        int v = 5;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{2, 4});
        adj.get(1).add(new int[]{2, 1});
        adj.get(1).add(new int[]{3, 7});
        adj.get(2).add(new int[]{4, 3});
        adj.get(3).add(new int[]{4, 2});
        
        int[] dist = getShortest(v,0,adj);
        
        System.out.println(Arrays.toString(dist));
        		
	}

}
