package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionDirectedGraph {
	public static boolean cycleCheck(int v, List<List<Integer>> adj) {
		Queue<Integer> q = new LinkedList<>();
		int[] indegree = new int[v];
		for(int i=0;i<v;i++) {
			for(int it : adj.get(i)) {
				indegree[it]++;
			}
		}
		for(int j=0;j<v;j++) {
			if(indegree[j]==0)
				q.add(j);
		}
		int nodeCount = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			nodeCount++;
			for(int neighbour : adj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
		}
		
		if(nodeCount<v) return true;
		
		return false;
	}
	public static void main(String[] args) {
		//V = 6, adj= [[1], [2, 5], [3], [4], [1], []]
/*		int v = 6;
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<6;i++) {
			adj.add(new ArrayList<>(Arrays.asList(1)));
			adj.add(new ArrayList<>(Arrays.asList(2,5)));
			adj.add(new ArrayList<>(Arrays.asList(3)));
			adj.add(new ArrayList<>(Arrays.asList(4)));
			adj.add(new ArrayList<>(Arrays.asList(1)));
			adj.add(new ArrayList<>(Arrays.asList()));
		}
		*/
		//Input:V = 4, adj= [[1,2], [2], [], [0,2]]
		int v = 4;
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<4;i++) {
			adj.add(new ArrayList<>(Arrays.asList(1,2)));
			adj.add(new ArrayList<>(Arrays.asList(2)));
			adj.add(new ArrayList<>(Arrays.asList()));
			adj.add(new ArrayList<>(Arrays.asList(0,2)));
		}
		boolean check = cycleCheck(v, adj);
		
		System.out.println(check);
	}

}
