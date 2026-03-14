package R.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversalBT {
	TNode root;
	
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
	public List<List<Integer>> zigzagTraversal(){
		List<List<Integer>> ans = new ArrayList<>();
		boolean flag = true;
		Queue<TNode> q = new LinkedList<>();
		
		q.add(root);
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> one = new ArrayList<>();
			Stack<Integer> rev = new Stack<>();			
			for(int i=0;i<size;i++) {
				TNode temp = q.poll();
				
				if(flag) {
					one.add(temp.data);
				}else {
					rev.push(temp.data);
				}				

				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
			while(!rev.isEmpty()) {
				one.add(rev.pop());
			}
			flag = !flag;
			ans.add(one);
		}
		
		
		return ans;
	}
	public void createBinaryTree() {
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
	}
	public static void main(String[] args) {
		ZigZagTraversalBT bt = new ZigZagTraversalBT();
		bt.createBinaryTree();
		
		List<List<Integer>> ans = bt.zigzagTraversal();
		
		System.out.println(ans.toString());
	}

}
