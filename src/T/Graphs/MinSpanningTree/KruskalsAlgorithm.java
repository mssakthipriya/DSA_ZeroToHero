package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class DisjointSetR{
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	
	public DisjointSetR(int n) {
		for(int i=0;i<=n;i++) {
			rank.add(0);
			parent.add(i);
		}
	}
	
	public int findUParent(int node) {
		if(node==parent.get(node)) {
			return node;
		}
		
		int ulp = findUParent(parent.get(node));
		parent.set(node, ulp);
		
		return parent.get(node);		
	}
	
	public void unionByRank(int u, int v) {
		int u_ulp = findUParent(u);
		int v_ulp =  findUParent(v);
		
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
}
public class KruskalsAlgorithm {
	
	public static int minSpanningTree(int v,List<List<List<Integer>>> adj) {
		int sum = 0;
		List<int[]> edges = new ArrayList<>();
		for(int i=0;i<v;i++) {
		for(List<Integer> edg : adj.get(i)) {
			int j = edg.get(0);
			int wt = edg.get(1);
			edges.add(new int[] {wt,i,j});
		}
		}
		
		edges.sort(Comparator.comparingInt(e -> e[0]));
		
		DisjointSetR dj = new DisjointSetR(v);
		
		for(int[] it : edges) {
			int wt = it[0];
			int ui = it[1];
			int vi = it[2];
			
			if(dj.findUParent(ui)!=dj.findUParent(vi)) {
				sum+=wt;
				dj.unionByRank(ui, vi);
			}
			
		}
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		int v = 4;
        List<int[]> edges = Arrays.asList(
            new int[]{0, 1, 1},
            new int[]{1, 2, 2},
            new int[]{2, 3, 3},
            new int[]{0, 3, 4}
        );
        
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) {
        	adj.add(new ArrayList<>());
        }
        adj.get(0).add(Arrays.asList(1,1));
        adj.get(1).add(Arrays.asList(0,1));
        adj.get(1).add(Arrays.asList(2,2));
        adj.get(2).add(Arrays.asList(1,2));
        adj.get(2).add(Arrays.asList(3,3));
        adj.get(3).add(Arrays.asList(2,3));
        adj.get(0).add(Arrays.asList(3,4));
        adj.get(3).add(Arrays.asList(0,4));
        
        
        int sum = minSpanningTree(v,adj);
        
        System.out.println(sum);
	}

}
