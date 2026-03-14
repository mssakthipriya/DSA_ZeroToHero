package R.BinaryTrees.Medium;

public class CheckBalancedBinaryTree {
	TNode root;
	
	class TNode{
		int data;
		TNode right;
		TNode left;
		
		TNode(int data){
			this.data = data;
			right = null;
			left = null;
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
		
		root = one;
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		seven.right = eight;
		eight.right = nine;
		
	}
	
	public int getHeightDiff(TNode root) {
		if(root==null) return 0;
		
		int lHeight = getHeightDiff(root.left);
		if(lHeight==-1) return -1;
			
		int rHeight = getHeightDiff(root.right);
		if(rHeight==-1) return -1;		
		
		if(Math.abs((int)((double)rHeight-(double)lHeight))>1) {
			return -1;
		}
		
		return Math.max(lHeight, rHeight)+1;
	}
	
	public boolean isBalanced() {
		return getHeightDiff(root)!=-1;
	}
	public static void main(String[] args) {
		CheckBalancedBinaryTree bt = new CheckBalancedBinaryTree();
		bt.createBinaryTree();
		
		boolean check = bt.isBalanced();
		
		if(check) {
			System.out.println("The tree is balanced");
		}else {
			System.out.println("The tree is not balanced");
		}
		
	}

}
