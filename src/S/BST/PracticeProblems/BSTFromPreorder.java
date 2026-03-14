package S.BST.PracticeProblems;

public class BSTFromPreorder {
	int count;
	public void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
    public TreeNode bstFromPreorder(int[] preorder) {
        count = 0;
        return createBST(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode createBST(int[] preorder, int bound) {
    	if(count==preorder.length || preorder[count]>bound) return null;
    	
    	TreeNode root = new TreeNode(preorder[count]);
    	count++;
    	root.left = createBST(preorder, root.val);
    	root.right = createBST(preorder, bound)	;	
    			
    	
    	return root;
    }
	
	public static void main(String[] args) {
		int[] preorder = {8,5,1,7,10,12};
		
		BSTFromPreorder obj = new BSTFromPreorder();
		
		TreeNode root = obj.bstFromPreorder(preorder);
		
		obj.inorder(root);
		System.out.println();
	}

}
