package T.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
	public static boolean dfs(int start, int col, List<List<Integer>> adjList,int[] colour) {
		colour[start] = col;		
		
		for(int neighbour : adjList.get(start)) {
			if(colour[neighbour]==-1) {
				if(dfs(neighbour, 1-col, adjList,colour)==false)
					return false;
			}
			if(colour[start]==colour[neighbour]) {
				return false;
			}
		}
		
		
		return true;
	}
	public static boolean isBipartite(int v, List<List<Integer>> adjList) {
		int[] colour = new int[v+1];
		for(int i=1;i<=v;i++) colour[i] = -1;
		
		for(int i=1;i<=v;i++) {
			if(colour[i]==-1) {
				if(dfs(i,0,adjList,colour)==false) {
					return false;
				}
			}

		}	
		
		return true;
	}
	public static void main(String[] args) {
		List<List<Integer>> adjList = new ArrayList<>();
/*		int v = 8;
		
			adjList.add(new ArrayList<>());
			adjList.add(Arrays.asList(2));
			adjList.add(Arrays.asList(1,3,6));
			adjList.add(Arrays.asList(2,4));
			adjList.add(Arrays.asList(3,7,5));
			adjList.add(Arrays.asList(4,6));
			adjList.add(Arrays.asList(2,5));
			adjList.add(Arrays.asList(4,8));
			adjList.add(Arrays.asList(7));
*/
		
		int v = 4;
		adjList.add(new ArrayList<>());
		adjList.add(Arrays.asList(2,4));
		adjList.add(Arrays.asList(1,3));
		adjList.add(Arrays.asList(2,4));
		adjList.add(Arrays.asList(1,3));
			
			boolean check = isBipartite(v, adjList);
			
			System.out.println(check);

		
	}

}
