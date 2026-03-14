package R.BinaryTrees.Hard;

public class ChildrenSumProperty {

	public void childrenSumTree(TreeNode root) {
		
		if(root==null) return;
		int child = 0;
		
		if(root.left!=null) child+=root.left.val;
		if(root.right!=null) child+=root.right.val;
		
		if(child>=root.val) root.val = child;
		else {
			if(root.left!=null) root.left.val = root.val;
			else if(root.right!=null) root.right.val = root.val;
		}
		
		childrenSumTree(root.left);
		childrenSumTree(root.right);
		
		int tot  = 0;
		if(root.left!=null) tot+=root.left.val;
		if(root.right!=null) tot+=root.right.val;
		
		if(root.left!=null || root.right!=null) root.val = tot;
		
	}
	
	public void inorder(TreeNode root) {
		if(root==null) return;
		
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
	     root.left = new TreeNode(35);
	     root.right = new TreeNode(10);
	     root.left.left = new TreeNode(2);
	     root.left.right = new TreeNode(3);
	     root.right.left = new TreeNode(5);
	     root.right.right = new TreeNode(2);
	     
	     ChildrenSumProperty obj = new ChildrenSumProperty();
	     obj.inorder(root);
	     System.out.println();
	     obj.childrenSumTree(root);
	     obj.inorder(root);
	     System.out.println();
	}

}
