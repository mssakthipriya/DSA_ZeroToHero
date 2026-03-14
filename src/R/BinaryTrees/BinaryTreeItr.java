package R.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeItr {
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
		
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
	}
	
	public List<Integer> inOrder(){	
		if(root==null) return null;
		
		List<Integer> inorder = new ArrayList<>();
		Stack<TNode> s = new Stack<>();	
		
		TNode temp = root;
		while(!s.isEmpty()||temp!=null) {
			
			if(temp!=null) {
				s.push(temp);
				temp=temp.left;
			}else {
				temp = s.pop();
				inorder.add(temp.data);
				temp=temp.right;
			}
		}
		
		return inorder;
	}
	
	public List<Integer> preOrder(){
		if(root==null) return null;
		
		List<Integer> preorder = new ArrayList<>();
		Stack<TNode> s = new Stack<>();
		
		s.push(root);
		while(!s.isEmpty()) {
			TNode temp = s.pop();
			preorder.add(temp.data);
			if(temp.right!=null) {
				s.push(temp.right);
			}
			if(temp.left!=null) {
				s.push(temp.left);
			}

		}
		
		return preorder;
	}
	public List<Integer> postOrderII(){
		if(root==null) return null;
		
		List<Integer> postorder = new ArrayList<>();
		Stack<TNode> s = new Stack<>();
		Stack<TNode> s2 = new Stack<>();
		TNode temp = root;
		s.push(temp);
		while(!s.isEmpty()) {
			temp=s.pop();
			s2.push(temp);
			if(temp.left!=null) {
				s.push(temp.left);
			}
			if(temp.right!=null) {
				s.push(temp.right);
			}
		}
		while(!s2.isEmpty()) {
			temp=s2.pop();
			postorder.add(temp.data);
		}
		
		return postorder;
	}
	public List<Integer> postOrder(){
		if(root==null) return null;
		
		List<Integer> postorder = new ArrayList<>();
		Stack<TNode> s = new Stack<>();
		
		TNode current = root;
		while(current!=null||!s.empty()) {
			if(current!=null) {
				s.push(current);
				current=current.left;
			}else {
				TNode temp = s.peek().right;
				if(temp==null) {
					temp = s.pop();
					postorder.add(temp.data);
					while(!s.empty() && temp==s.peek().right) {
						temp=s.pop();
						postorder.add(temp.data);
					}
					
				}else {
					current=temp;
				}
			}
		}
		
		return postorder;
	}
	
	public List<Integer> levelOrder(){
		if(root==null) return null;
		
		List<Integer> levelorder = new ArrayList<>();
		Queue<TNode> q = new LinkedList<>();
		
		TNode temp = root;
		q.add(temp);
		while(!q.isEmpty()) {
			temp=q.poll();
			levelorder.add(temp.data);
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		
		return levelorder;
	}
	
	public static void main(String[] args) {
		BinaryTreeItr bt = new BinaryTreeItr();
		bt.createBinaryTree();
		
		List<Integer> inorder = bt.inOrder();
		System.out.println("inorder: "+inorder.toString());
		
		List<Integer> preorder = bt.preOrder();
		System.out.println("preorder: "+preorder.toString());
		
		List<Integer> postorder = bt.postOrder();
		System.out.println("postorder: "+postorder.toString());
		
		List<Integer> postorderII = bt.postOrderII();
		System.out.println("postorderII: "+postorderII.toString());
		
		List<Integer> levelorder = bt.levelOrder();
		System.out.println("postorder: "+levelorder.toString());
	}

}
