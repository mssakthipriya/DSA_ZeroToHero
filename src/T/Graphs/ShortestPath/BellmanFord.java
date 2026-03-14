package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
	
	public static int[] bellmanFord(int v, ArrayList<ArrayList<Integer>> edges, int s) {
		int[] dist = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for(int j=0;j<v;j++) {
			for(int i=0;i<edges.size();i++) {
				ArrayList<Integer> edge = edges.get(i); 
				int src = edge.get(0);
				int dest = edge.get(1);
				int wt = edge.get(2);
				
				if(dist[src] != Integer.MAX_VALUE && dist[dest]>dist[src]+wt) {
					dist[dest] = dist[src]+wt;
				}
			}
		}
		
		for(int i=0;i<edges.size();i++) {
			ArrayList<Integer> edge = edges.get(i); 
			int src = edge.get(0);
			int dest = edge.get(1);
			int wt = edge.get(2);
			
			if(dist[dest]>dist[src]+wt) {
				int[] temp = new int[1];
				temp[0]=-1;
				return temp;
			}
		}

		
		
		return dist;
	}
	public static void main(String[] args) {

        int v = 6;
        int s = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        int[] dist = bellmanFord(v, edges, s);
        for (int i = 0; i < v; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
	}

}
