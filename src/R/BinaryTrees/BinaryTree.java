package R.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	TNode root;
	
	class TNode{
		int data;
		TNode right;
		TNode left;
		
		TNode(int data){
			this.data=data;
			right = null;
			left = null;
		}
	}
	public void inOrder(TNode root, List<Integer> arr){
		if(root==null) {
			return;
		}		
		inOrder(root.left,arr);
		arr.add(root.data);
		inOrder(root.right,arr);
	}
	public void preOrder(TNode root, List<Integer> arr){
		if(root==null) {
			return;
		}
		arr.add(root.data);
		preOrder(root.left,arr);
		preOrder(root.right,arr);
	}
	public void postOrder(TNode root, List<Integer> arr){
		if(root==null) {
			return;
		}		
		postOrder(root.left,arr);
		postOrder(root.right,arr);
		arr.add(root.data);
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
		root.left=two;
		root.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.createBinaryTree();
		
		List<Integer> inorder = new ArrayList<>();
		bt.inOrder(bt.root, inorder);
		System.out.println("inorder: "+inorder.toString());
		
		List<Integer> preorder = new ArrayList<>();
		bt.preOrder(bt.root, preorder);
		System.out.println("preorder: "+preorder.toString());
		
		List<Integer> postorder = new ArrayList<>();
		bt.postOrder(bt.root, postorder);
		System.out.println("postorder: "+postorder.toString());
	}

}
