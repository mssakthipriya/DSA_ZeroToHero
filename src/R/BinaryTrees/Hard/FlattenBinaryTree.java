package R.BinaryTrees.Hard;

public class FlattenBinaryTree {
	
	public void preorder(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void printFlattenTree(TreeNode root) {
		if(root == null) return;
		
		System.out.print(root.val+" ");
		printFlattenTree(root.right);
	}
	
	public void flattenTree(TreeNode root) {
		TreeNode curr = root;
		
		while(curr!=null) {
			
			if(curr.left!=null) {
				TreeNode prev = curr.left;
				
				while(prev.right!=null) {
					prev = prev.right;
				}
				
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}

			curr = curr.right;
			
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		
		FlattenBinaryTree obj = new FlattenBinaryTree();
		
		obj.preorder(root);
		System.out.println();
		
		obj.flattenTree(root);
		obj.printFlattenTree(root);
		System.out.println();
		
	}

}
