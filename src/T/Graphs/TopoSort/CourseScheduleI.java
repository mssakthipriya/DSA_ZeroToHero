package T.Graphs.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {
	public static boolean schedulePossible(int n, int[][] pre) {
		List<List<Integer>> adj = new ArrayList<>();
		int[] indegree = new int[n];
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<pre.length;i++) {
			adj.get(pre[i][1]).add(pre[i][0]);
			int x  = pre[i][0];
			indegree[x]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		int count=0;
		while(!q.isEmpty()) {
			int node = q.poll();
			count++;
			for(int neighbour : adj.get(node)) {
				indegree[neighbour]--;
				if(indegree[neighbour]==0) {
					q.add(neighbour);
				}
			}
		}

		System.out.println(count);
		
		return count==n;
	}
	public static void main(String[] args) {
		
		//int n = 4;
		//int[][] pre = {{1,0},{2,1},{3,2}};
		
		int n = 4;
		int[][] pre = {{0,1},{3,2},{1,3},{3,0}};
		
		boolean check = schedulePossible(n,pre);
		
		System.out.println(check);
		
	}

}
