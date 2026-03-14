package R.BinaryTrees.Hard;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreorderInorder {
	
	public void inorderTraversal(TreeNode root) {
		if(root == null) return;
		
		inorderTraversal(root.left);
		System.out.print(root.val+" ");
		inorderTraversal(root.right);
	}
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int n = preorder.length;
    	Map<Integer,Integer> inorderMap = new HashMap<>();
    	
    	for(int i=0;i<inorder.length;i++) {
    		inorderMap.put(inorder[i], i);
    	}
    	
    	return build(preorder, 0, n-1, inorder, 0, n-1, inorderMap);
    }
    
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap) {
    	if(preStart>preEnd || inStart > inEnd) return null;
    	
    	TreeNode root = new TreeNode(preorder[preStart]);
    	
    	int inRoot = inMap.get(root.val);
    	int numsLeft = inRoot - inStart;
    	
    	root.left = build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, inRoot-1, inMap);
    	root.right = build(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1, inEnd, inMap);
    	
    	return root;
    }
	
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		BTFromPreorderInorder obj = new BTFromPreorderInorder();
		TreeNode root = obj.buildTree(preorder,inorder);
		
		obj.inorderTraversal(root);
		System.out.println();
		
	}

}
