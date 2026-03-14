package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	public static List<Integer> getSchedule(int n, int[][] pre){
		List<Integer> ans = new ArrayList<>();
		List<List<Integer>> adj = new ArrayList<>();
		int[] indegree = new int[n];
		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int[] p:pre) {
			int a = p[1];
			int b = p[0];
			adj.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);
			for(int neighbour: adj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
		}
		
		if(ans.size()!=n) {
			return new ArrayList<Integer>();
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int n = 4;
		int[][] pre = {{1,0},{2,1},{3,2}};
		
		//int n = 4;
		//int[][] pre = {{0,1},{3,2},{1,3},{3,0}};
		
		List<Integer> ans = getSchedule(n,pre);
		
		System.out.println(ans.toString());
	}

}
