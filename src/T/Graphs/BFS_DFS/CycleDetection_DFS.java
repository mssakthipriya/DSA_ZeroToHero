package T.Graphs.BFS_DFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CycleDetection_DFS {
	public static boolean dfs(int start, int parent,boolean[] visited, List<List<Integer>> adjList) {
		
		visited[start] = true;
		
		for(int neighbour: adjList.get(start)) {
			if(!visited[neighbour]) {
				if(dfs(neighbour, start, visited, adjList)) {
					return true;		
			}
			}else if(parent!=neighbour) {
				return true;
			}
		}
		
		
		return false;
	}
	public static boolean detectCycles(int v, List<List<Integer>> adjList) {
		
		boolean[] visited = new boolean[v+1];
		
		for(int i=1;i<=v;i++) {
			if(!visited[i]) {
				if(dfs(i,-1,visited,adjList)) return true;
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
		
		boolean ans = detectCycles(v,adjList);
		
		System.out.println(ans);
	}

}
