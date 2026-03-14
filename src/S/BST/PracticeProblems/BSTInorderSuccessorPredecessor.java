package S.BST.PracticeProblems;

public class BSTInorderSuccessorPredecessor {
	
	public TreeNode onorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		
		while(root!=null) {
			if(root.val<=p.val) {
				root = root.right;
			}else {
				successor = root;
				root = root.left;
			}
		}		
		
		return successor;
	}
	
	public TreeNode onorderPredecessor(TreeNode root, TreeNode p) {
		TreeNode predecessor = null;
		
		while(root!=null) {
			if(root.val >= p.val) {
				root = root.left;
			}else {
				predecessor = root;
				root = root.right;
			}
		}
		
		return predecessor;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(10);
		
		BSTInorderSuccessorPredecessor obj = new BSTInorderSuccessorPredecessor();
		
		TreeNode successor = obj.onorderSuccessor(root, root.right.right.left);
		System.out.println("successor: "+successor.val);
		
		TreeNode predecessor = obj.onorderPredecessor(root, root.right.right.left);
		System.out.println("predecessor: "+predecessor.val);
	}

}
