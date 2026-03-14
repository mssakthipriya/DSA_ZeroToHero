package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SafeStates {
	
	public static List<Integer> getSafeNodes(int v,List<List<Integer>> adj){
		List<Integer> ans = new ArrayList<>();
		
		List<List<Integer>> revAdj = new ArrayList<>();
		for(int i=0;i<v;i++) {
			revAdj.add(new ArrayList<>());
		}
		
		for(int i=0;i<v;i++) {
			for(int it : adj.get(i)) {
				revAdj.get(it).add(i);
			}
		}
		
		int[] indegree = new int[v];
		
		for(int i=0;i<v;i++) {
			for(int it:revAdj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);
			for(int neighbour: revAdj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
		}
		
		ans.sort(null);
		return ans;
	}
	public static void main(String[] args) {

        int v = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        List<Integer> safeNodes = getSafeNodes(v, adj); 

       System.out.println(safeNodes.toString());

	}

}
