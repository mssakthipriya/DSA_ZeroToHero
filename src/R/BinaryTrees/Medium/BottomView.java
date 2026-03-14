package R.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
	TNode root;
	
	class Pair<K,V>{
		private K key;
		private V value;
		
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	class TNode{
		int data;
		TNode left;
		TNode right;
		
		TNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public void createBinaryTree() {
		TNode one  = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode nine = new TNode(9);
		TNode ten = new TNode(10);
		TNode eleven = new TNode(11);
		
		root = one;
		root.left = two;
		root.right = three;
		two.left = four;
		four.right = five;
		five.right = six;
		two.right = ten;
		three.left = nine;
		three.right = eleven;
	}
	public List<Integer> getBottom(){
		List<Integer> ans = new ArrayList<>();
		
		if(root==null) {
			return ans;
		}
		
		Queue<Pair<TNode,Integer>> q = new LinkedList<>();
		
		Map<Integer,Integer> map = new TreeMap<>();
		
		TNode temp = root;
		q.add(new Pair<>(temp,0));
			
		while(!q.isEmpty()) {
			Pair<TNode,Integer> p = q.poll();
			temp = p.getKey();
			int line = p.getValue();
			map.put(line, temp.data);
			
			if(temp.left!=null) {
				q.add(new Pair<>(temp.left,line-1));
			}
			if(temp.right!=null) {
				q.add(new Pair<>(temp.right,line+1));
			}
		}
		
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
		
		return ans;
	}
	public static void main(String[] args) {
		BottomView bt = new BottomView();
		bt.createBinaryTree();
		
		List<Integer> list = bt.getBottom();
		System.out.println(list);
	}
}
