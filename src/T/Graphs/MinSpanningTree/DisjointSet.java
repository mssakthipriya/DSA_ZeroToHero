package T.Graphs.MinSpanningTree;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	List<Integer> rank = new ArrayList<>();
	List<Integer> size = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	
	public DisjointSet(int n) {
		for(int i=0;i<=n;i++) {
			rank.add(0);
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
	
	public void unionbyRank(int u, int v)
	{
		int u_ulp = findUParent(u);
		int v_ulp = findUParent(v);
		
		if(u_ulp == v_ulp) {
			return;
		}
		
		if(rank.get(u_ulp)<rank.get(v_ulp)) {
			parent.set(u_ulp, v_ulp);
		}else if(rank.get(u_ulp)>rank.get(v_ulp)) {
			parent.set(v_ulp, u_ulp);
		}else {
			parent.set(v_ulp, u_ulp);
			rank.set(u_ulp, rank.get(u_ulp)+1);
		}
		
		
	}
	
	public void unionbySize(int u, int v)
	{
		int u_ulp = findUParent(u);
		int v_ulp = findUParent(v);
		
		if(u_ulp == v_ulp) {
			return;
		}
		
		if(size.get(u_ulp)<size.get(v_ulp)) {
			parent.set(u_ulp, v_ulp);
			size.set(v_ulp, size.get(v_ulp)+size.get(u_ulp));
		}else {
			parent.set(v_ulp, u_ulp);
			size.set(u_ulp, size.get(v_ulp)+size.get(u_ulp));
		}
	}
	
	public int getSize(int node) {
		return size.get(findUParent(node));
	}

}
