package R.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class VerticalOrderTraversal {
	TNode root;
	class Pair<K,V>{
		private K key;
		private V value;
		
		public Pair(K key,V value) {
			this.key=key;
			this.value=value;
		}
		
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		
		public void setValue(V val) {
			this.value = val;
		}
	}
	class TNode{
		int data;
		TNode right;
		TNode left;
		
		TNode(int data){
			this.data=data;
			right=null;
			left=null;
		}
	}
	
	public void createBinaryTree() {
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode nine = new TNode(9);
		TNode ten = new TNode(10);
		TNode eleven = new TNode(11);
		
		root=one;
		root.left=two;
		root.right=three;
		two.left=four;
		two.right=ten;
		three.left=nine;
		three.right=eleven;
		four.right=five;
		five.right=six;
		
	}
	
	public List<List<Integer>> verticalTraversal() {
		List<List<Integer>> ans =  new ArrayList<>();
		
		Map<Integer,Map<Integer,TreeSet<Integer>>> nodes = new TreeMap<>();
		Queue<Pair<TNode,Pair<Integer,Integer>>> q = new LinkedList<>();
		
		q.add(new Pair<>(root,new Pair<>(0,0)));
		
		while(!q.isEmpty()) {
			
			Pair<TNode,Pair<Integer,Integer>> p= q.poll();
			TNode temp = p.getKey();
			
			//vertical
			int x = p.getValue().getKey();
			//level
			int y = p.getValue().getKey();
			
			nodes.computeIfAbsent(x, k->new TreeMap<>()).computeIfAbsent(y, k->new TreeSet<>()).add(temp.data);
			
			if(temp.left!=null) {
				q.add(new Pair<>(temp.left,new Pair<>(x-1,y+1)));
			}
			if(temp.right!=null) {
				q.add(new Pair<>(temp.right,new Pair<>(x+1,y+1)));
			}
		}
		
		for(Map.Entry<Integer, Map<Integer,TreeSet<Integer>>> entry: nodes.entrySet()) {
			List<Integer> list = new ArrayList<>();
			
			for(TreeSet<Integer> set: entry.getValue().values()) {
				list.addAll(set);
			}
			ans.add(list);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		VerticalOrderTraversal bt = new VerticalOrderTraversal();
		bt.createBinaryTree();
		
		List<List<Integer>> ans = bt.verticalTraversal();
		
		System.out.println(ans.toString());
	}

}
