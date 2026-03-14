package L.RecursionPattern.Combos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MColoring {
	
	public static boolean isSafe(Map<Integer,List<Integer>> graph,int color,int[] nodeColor,int node) {
		for(int i:graph.get(node)) {
			if(nodeColor[i]==color) return false;
		}
		
		return true;
	}
	
	public static boolean canColor(Map<Integer,List<Integer>> graph, int c,int[] nodeColor,int node,int n) {
		if(node==n) return true;
		
		for(int i=1;i<=c;i++) {
			if(isSafe(graph,i,nodeColor,node)) {
				nodeColor[node]=i;
				if(canColor(graph,c,nodeColor,node+1,n)==true)return true;
				nodeColor[node]=0;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		int c = 3;
		Map<Integer, List<Integer>> graph= new HashMap<>();
		graph.put(0, Arrays.asList(1,2,3));
		graph.put(1, Arrays.asList(0,2));
		graph.put(2, Arrays.asList(0,1,3));
		graph.put(3, Arrays.asList(0,2)); 
		
/*		int c = 2;
		Map<Integer, List<Integer>> graph= new HashMap<>();
		graph.put(0, Arrays.asList(1,2));
		graph.put(1, Arrays.asList(0,2));
		graph.put(2, Arrays.asList(0,1)); */
		
		int n = graph.size();
		int[] nodeColor = new int[n];
		boolean ans = canColor(graph,c,nodeColor,0,n);
		
		System.out.println("Can we color the complete graph:"+ans);
		
	}

}
