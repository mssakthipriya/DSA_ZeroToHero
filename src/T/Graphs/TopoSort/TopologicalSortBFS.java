package T.Graphs.TopoSort;
//Kahn's algorithm
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS {
	
	public static List<Integer> getTopoOrder(int v, List<List<Integer>> adj){
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();

		int[] indegree = new int[v];
		for(int i=0;i<v;i++) {
			for(int it : adj.get(i)) {
				indegree[it]++;
			}
		}
		
		for(int i=0;i<v;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);
			for(int neighbour : adj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
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
