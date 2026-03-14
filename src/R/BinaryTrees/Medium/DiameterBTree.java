package R.BinaryTrees.Medium;

public class DiameterBTree {
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
	
	public int getHeight(int[] diameter,TNode root) {
		if(root==null) return 0;
		
		int lHeight = getHeight(diameter, root.left);
		int rHeight = getHeight(diameter, root.right);
		
		diameter[0] = Math.max(diameter[0],lHeight+rHeight);
		
		return Math.max(lHeight, rHeight)+1;
	}
	
	public int getDiameter() {
		int[] diameter = new int[1];
		getHeight(diameter,root);
		return diameter[0];
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
		three.left = four;
		three.right = six;
		four.left = five;
		six.right = seven;
		five.left = nine;
		seven.right = eight;
	}
	
	public static void main(String[] args) {
		DiameterBTree bt = new DiameterBTree();
		bt.createBinaryTree();
		
		int diameter = bt.getDiameter();
		
		System.out.println(diameter);
	}

}
