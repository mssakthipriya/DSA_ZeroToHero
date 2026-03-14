package S.BST.PracticeProblems;

public class ValidateBST {
	
	public boolean isValidBST(TreeNode root) {
		
		boolean check = checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		return check;
	}
	
	public boolean checkBST(TreeNode root, int minVal, int maxVal) {
		
		if(root==null) return true;
		
		if(root.val<=minVal || root.val>=maxVal) return false;
		
		return checkBST(root.left, minVal, root.val) && checkBST(root.right, root.val, maxVal);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		ValidateBST obj = new ValidateBST();
		
		boolean check = obj.isValidBST(root);
		
		System.out.println(check);
		
	}

}
