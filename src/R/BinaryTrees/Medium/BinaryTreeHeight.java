package R.BinaryTrees.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeHeight {
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
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
		seven.right=eight;
	}
	
	public int getHeight() {
		if(root==null) return 0;
		int height=0;
		Queue<TNode> q = new LinkedList<>();
		
		TNode temp = root;
		q.add(temp);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				temp = q.poll();
				if(temp.right!=null) {
					q.add(temp.right);
				}
				if(temp.left!=null) {
					q.add(temp.left);
				}				
			}
			height++;
		}
		
		return height;
	}
	
	public int getHeightII(TNode root) {
		if(root==null) return 0;
		
		int hLeft = getHeightII(root.left);
		int hRight = getHeightII(root.right);
		
		return Math.max(hLeft, hRight)+1;
	}
	public static void main(String[] args) {
		BinaryTreeHeight bt = new BinaryTreeHeight();
		
		bt.createBinaryTree();
		int height = bt.getHeight();
		int heightII = bt.getHeightII(bt.root);
		
		System.out.println("The height of the binary tree is:"+ height);
		System.out.println("The height of the binary tree is:"+ heightII);
	}
	
}
