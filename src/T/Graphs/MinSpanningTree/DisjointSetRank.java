package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetRank {
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	
	public DisjointSetRank(int n) {
		for(int i=0;i<=n;i++) {
			rank.add(0);
			parent.add(i);
		}
	}
	
	public int findUParent(int node) {
		if(node==parent.get(node)) {
			return node;
		}
		
		int uParent = findUParent(parent.get(node));		
		parent.set(node, uParent);
		
		return parent.get(node);
	}
	
	public void unionByRank(int u, int v) {
		int u_ulp = findUParent(u);
		int v_ulp = findUParent(v);
		
		if(u_ulp==v_ulp) {
			return;
		}
		
		if(rank.get(u_ulp)> rank.get(v_ulp)) {
			parent.set(v_ulp, u_ulp);
		}else if(rank.get(u_ulp)< rank.get(v_ulp)) {
			parent.set(u_ulp, v_ulp);
		}else {
			parent.set(v_ulp, u_ulp);
			rank.set(u_ulp, rank.get(u_ulp)+1);
		}
	}
	
	public static void main(String[] args) {
        DisjointSetRank ds = new DisjointSetRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
