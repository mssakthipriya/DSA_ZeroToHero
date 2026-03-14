package R.BinaryTrees.Medium;

public class MaxPathSum {
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
	
	public int calculate(TNode root, int[] maxVal) {
		if(root == null) return 0;
		
		int lVal = Math.max(0,calculate(root.left, maxVal));
		int rVal = Math.max(0,calculate(root.right, maxVal));
		
		maxVal[0] = Math.max(maxVal[0], lVal+rVal+root.data);
		
		return Math.max(lVal, rVal)+root.data;
	}
	
	public int getMaxSum() {
		int[] max = {Integer.MIN_VALUE};
		
		calculate(root,max);
		
		return max[0];		
	}
	
	public void createBinaryTree() {
		TNode one = new TNode(-10);
		TNode two = new TNode(9);
		TNode three = new TNode(20);
		TNode four = new TNode(15);
		TNode five = new TNode(7);
		
		root = one;
		root.left = two;
		root.right = three;
		three.left = four;
		three.right = five;
	}
	
	public static void main(String[] args) {
		MaxPathSum bt = new MaxPathSum();
		bt.createBinaryTree();
		
		int max = bt.getMaxSum();
		
		System.out.println(max);
	}

}
