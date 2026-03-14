package R.BinaryTrees.Medium;

public class SymmetricBinaryTree {
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		
		TNode(int data){
			this.data = data;
			right = null;
			left = null;
		}
	}
	
	public void createBinaryTree() {
		TNode one  = new TNode(1);
		TNode two  = new TNode(2);
		TNode twoII = new TNode(2);
		TNode three  = new TNode(3);
		TNode threeII = new TNode(3);
		TNode four  = new TNode(4);
		TNode fourII = new TNode(4);
		
		root = one;
		root.left = two;
		root.right = twoII;
		two.left = three;
		two.right = four;
		twoII.left = fourII;
		twoII.right = threeII;
	}

	
	public boolean isSymmetric(TNode root) {
	    if (root == null) return true;
	    return isMirror(root.left, root.right);
	}

	private boolean isMirror(TNode t1, TNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;

	    return (t1.data == t2.data)
	        && isMirror(t1.left, t2.right)
	        && isMirror(t1.right, t2.left);
	}
	
	public static void main(String[] args) {
		SymmetricBinaryTree bt = new SymmetricBinaryTree();
		bt.createBinaryTree();
		
		boolean check = bt.isSymmetric(bt.root);
		
		System.out.println(check);
	}
}
