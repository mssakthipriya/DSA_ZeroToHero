package R.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.List;

public class LeftRightView {
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
	public void leftRecursion(TNode root,int level,List<Integer> ans) {
		if(root==null) return;
		
		if(ans.size()==level) {
			ans.add(root.data);
		}
		leftRecursion(root.left,level+1,ans);
		leftRecursion(root.right,level+1,ans);
		
	}
	public void rightRecursion(TNode root,int level,List<Integer> ans) {
		if(root==null) return;
		if(ans.size()==level) {
			ans.add(root.data);
		}
		
		rightRecursion(root.right,level+1,ans);
		rightRecursion(root.left,level+1,ans);
		
	}
	public List<Integer> getLeftList(){
		List<Integer> ans = new ArrayList<>();
		leftRecursion(root,0,ans);
		return ans;
	}
	
	public List<Integer> getRightList(){
		List<Integer> ans = new ArrayList<>();
		 rightRecursion(root,0,ans);
		return ans;
	}
	
	public static void main(String[] args) {
		LeftRightView bt = new LeftRightView();
		bt.createBinaryTree();
		
		List<Integer> leftList = bt.getLeftList();
		List<Integer> rightList = bt.getRightList();
		
		System.out.println("Left List:"+ leftList.toString());
		System.out.println("Right List:"+ rightList.toString());
		
	}
}
