package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetSize {
	List<Integer> size = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	
	public DisjointSetSize(int n) {
		for(int i=0;i<=n;i++) {
			size.add(1);
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
	
	public void unionBySize(int u, int v) {
		int u_ulp = findUParent(u);
		int v_ulp = findUParent(v);
		
		if(u_ulp == v_ulp) {
			return;
		}
		
		if(size.get(u_ulp)<size.get(v_ulp)) {
			parent.set(u_ulp, v_ulp);
			size.set(v_ulp, size.get(u_ulp)+size.get(v_ulp));
		}else {
			parent.set(v_ulp, u_ulp);
			size.set(u_ulp, size.get(u_ulp)+size.get(v_ulp));
		}
		
	}
	
	public static void main(String[] args) {
        DisjointSetSize ds = new DisjointSetSize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
