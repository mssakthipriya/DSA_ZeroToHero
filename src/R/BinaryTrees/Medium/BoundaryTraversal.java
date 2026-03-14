package R.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import J.Strings.Easy.AnagramChecker;

public class BoundaryTraversal {
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		
		TNode(int data){
			this.data = data;
			left=null;
			right=null;
		}
	}
	
	public void createBinaryTree() {
		
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		TNode eight = new TNode(8);
		TNode nine = new TNode(9);
		TNode ten = new TNode(10);
		TNode eleven = new TNode(11);
		
		root = one;
		one.left = two;		
		two.left = three;
		three.right = four;
		four.left = five;
		four.right = six;
		one.right = seven;
		seven.right = eight;
		eight.left = nine;
		nine.left = ten;
		nine.right = eleven;
	}
	
	public boolean isLeaf(TNode node) {
		if(node.right==null && node.left==null) {
			return true;
		}		
		return false;
	}
	
	public Queue<Integer> addLeft(){
		Queue<Integer> q = new LinkedList<>();
		TNode temp = root.left;
		
		while(temp!=null) {
			if(!isLeaf(temp)) {
				q.add(temp.data);
			}
			if(temp.left!=null) {				
				temp=temp.left;
			}else {
				temp=temp.right;
				
			}
		}
		
		return q;
	}
	
	public void addLeaf(TNode root,Queue<Integer> l){
		 if(isLeaf(root)) {
			 l.add(root.data);
		 }
		 
		 if(root.left!=null) {
			 addLeaf(root.left,l);
		 }
		 if(root.right!=null) {
			 addLeaf(root.right,l);
		 }
		

	}
	
	public Stack<Integer> addRight(){
		Stack<Integer> s = new Stack<>();
		TNode temp = root.right;
		
		while(temp!=null) {
			if(!isLeaf(temp)) {
				s.add(temp.data);
			}
			
			if(temp.right!=null) {
				temp=temp.right;
			}else {
				temp=temp.left;
			}
		}
		
		return s;
	}
	
	public List<Integer> traverseAntiClockWise(){
		List<Integer> ans = new ArrayList<>();
		ans.add(root.data);
		Queue<Integer> q = addLeft();
		Queue<Integer> l = new LinkedList<>();
		addLeaf(root,l);
		Stack<Integer> s = addRight();
		
		ans.addAll(q);
		ans.addAll(l);
		while(!s.isEmpty()) {
			ans.add(s.pop());
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		BoundaryTraversal bt = new BoundaryTraversal();
		
		bt.createBinaryTree();
		
		List<Integer> list = bt.traverseAntiClockWise();
		
		System.out.println(list.toString());
	}

}
