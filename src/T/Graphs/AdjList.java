package T.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AdjList {
	private Map<Integer,List<Integer>> adj;
	
	public AdjList() {
		adj = new HashMap<>();
	}
	
	public void addVertex(int vertex) {
		adj.put(vertex, new ArrayList<Integer>());
	}
	
	public void removeVertex(int vertex) {
		adj.remove(vertex);
		for(List<Integer> value: adj.values() ) {
			if(value.contains(vertex)) {
				value.remove(Integer.valueOf(vertex));
			}
		}
	}
	
	public void addEdge(int i,int j) {

		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	
	public void removeEdge(int i,int j) {
		adj.get(i).remove(Integer.valueOf(j));
		adj.get(j).remove(Integer.valueOf(i));
	}
	
	public void printGraph() {
		for(Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue().toString());
		}
	}
	
	public List<Integer> DFSItr(int start){
		List<Integer> ans = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> st = new Stack<>();
		
		st.push(start);
		while(!st.isEmpty()) {
			int node = st.pop();
			if(visited.contains(node)) continue;
			visited.add(node);
			ans.add(node);
			
			List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
			for (int i = neighbors.size() - 1; i >= 0; i--) {
			    int v = neighbors.get(i);
			    if (!visited.contains(v)) {
			        st.push(v);
			    }
			}
			
		}
		return ans;
	}
	
	public void DFSHelper(int start, boolean[] visited,List<Integer> ans) {
		visited[start] = true;
		ans.add(start);
		int size = adj.get(start).size();
		for(int i=0;i<size;i++) {
			int node = adj.get(start).get(i);
			if(!visited[node]) {
				DFSHelper(node,visited,ans);
			}
		}
	}
	
	public List<Integer> DFSRec(int start){
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[adj.size()+1];
		DFSHelper(start,visited,ans);
		return ans;
	}
	public List<Integer> BFS(int start){
		List<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[adj.size()+1];
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);
			
			int size = adj.get(node).size();
			for(int i=0;i<size;i++) {
				int v =  adj.get(node).get(i);
				if(!visited[v]) {
					q.add(v);
					visited[v]=true;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		AdjList list = new AdjList();
		
		list.addVertex(1);
		list.addVertex(2);
		list.addVertex(3);
		list.addVertex(4);
		list.addVertex(5);
		list.addEdge(1, 2);
		list.addEdge(2, 3);
		list.addEdge(3, 4);
		list.addEdge(4, 1);
		list.addEdge(5, 4);
		list.addEdge(5, 3);
		list.printGraph();
		System.out.println("-----------");
		list.addVertex(6);
		list.addEdge(5, 6);
		list.printGraph();
		System.out.println("-----------");
		list.removeVertex(6);
		list.printGraph();
		System.out.println("-----------");
		
		//DFS
		System.out.println("DFS:");
		List<Integer> dfsItrList = list.DFSItr(1);
		System.out.println(dfsItrList.toString());
		List<Integer> dfsRecList = list.DFSRec(1);
		System.out.println(dfsRecList.toString());
		//BFS
		System.out.println("BFS:");
		List<Integer> bfsList = list.BFS(1);
		System.out.println(bfsList.toString());
		
	}

}
