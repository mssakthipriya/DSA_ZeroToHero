package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class MakeNetworkConnected {
	public static int findParent(int node,List<Integer> parent) {
		if(node==parent.get(node)) {
			return node;
		}
		
		int ulp = findParent(parent.get(node), parent);
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public static void unionByRank(int u, int v,List<Integer> parent,List<Integer> rank) {
		int u_ulp = findParent(u, parent);
		int v_ulp = findParent(v, parent);
		
		if(u_ulp == v_ulp) {
			return;
		}
		
		if(rank.get(v_ulp)<rank.get(u_ulp)) {
			parent.set(v_ulp, u_ulp);
		}else if(rank.get(v_ulp)>rank.get(u_ulp)) {
			parent.set(u_ulp, v_ulp);
		}else {
			parent.set(v_ulp, u_ulp);
			rank.set(u_ulp, rank.get(u_ulp)+1);
			
		}
		
	}
    public static int makeConnected(int n, int[][] connections) {
    
    	if(connections.length<n-1) return -1;
    	int cntExtras = 0;
    	List<Integer> rank = new ArrayList<>();
    	List<Integer> parent = new ArrayList<>();
    	
    	for(int i=0;i<n;i++) {
    		rank.add(0);
    		parent.add(i);
    	}
    	
    	for(int i=0;i<connections.length;i++) {
    		int u = connections[i][0];
    		int v = connections[i][1];
    		
    		if(parent.get(u)==parent.get(v)) {
    			cntExtras++;
    		}else {
    			unionByRank(u, v, parent, rank);
    		}
    		
    	}
    	int cntCmp=0;
    	for(int i=0;i<n;i++) {
    		if(parent.get(i)==i) {
    			cntCmp++;
    		}
    	}
    	
    	if(cntExtras>=cntCmp-1) return cntCmp-1;
    	
    	return -1;
    }
	public static void main(String[] args) {
		int n = 9;
		int[][] edge = {{0,1},{0,2},{0,3},{1,2},{2,3},{4,5},{5,6},{7,8}};
		
		int edgeCount = makeConnected(n,edge);
		
		System.out.println(edgeCount);
	}

}
