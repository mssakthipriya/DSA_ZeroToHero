package T.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

import Z.Utilities.*;

public class CycleDetection_BFS {
	public static boolean detectCycles(int v, List<List<Integer>> adjList, int start) {
		
		Queue<Pair<Integer,Integer>> q = new LinkedList<>();
		boolean[] visited = new boolean[v+1];
		visited[0] = true;
		
		q.add(new Pair<>(start,-1));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Pair<Integer,Integer> pair = q.poll();
			int node = pair.getKey();
			int parent = pair.getValue();
			
			for(int neighbour : adjList.get(node)) {
				if(!visited[neighbour]) {
					q.add(new Pair<>(neighbour,node));
					visited[neighbour]=true;
				}
				else if(parent!=neighbour) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		int v = 7;
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0;i<=v;i++) {
			adjList.add(new ArrayList<>());
		}
		
		adjList.get(1).addAll(Arrays.asList(2,3));
		adjList.get(2).addAll(Arrays.asList(1,5));
		adjList.get(3).addAll(Arrays.asList(1,4,6));
		adjList.get(4).addAll(Arrays.asList(3));
		adjList.get(5).addAll(Arrays.asList(2,7));
		adjList.get(6).addAll(Arrays.asList(3,7));
		adjList.get(7).addAll(Arrays.asList(5,6));
		
		boolean ans = detectCycles(v,adjList,1);
		
		System.out.println(ans);
	}

}
