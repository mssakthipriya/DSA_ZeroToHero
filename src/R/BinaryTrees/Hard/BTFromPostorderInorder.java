package R.BinaryTrees.Hard;

import java.util.HashMap;
import java.util.Map;

public class BTFromPostorderInorder {
	
	public void inorderTraversal(TreeNode root) {
		if(root == null) return;
		
		inorderTraversal(root.left);
		System.out.print(root.val+" ");
		inorderTraversal(root.right);
	}
	
	public TreeNode buildTree(int[] postorder, int[] inorder) {
		
		Map<Integer,Integer> inMap = new HashMap<>();
		
		for(int i=0;i<inorder.length;i++) {
			inMap.put(inorder[i], i);
		}
		
		return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inMap);
	}
	
	public TreeNode build(int[] postorder,int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> inMap) {
		
		if(inStart>inEnd || postStart>postEnd) return null;
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		
		int inRoot = inMap.get(root.val);
		int leftLength = inRoot-inStart;
		
		root.left = build(postorder, postStart, postStart+leftLength-1, inorder, inStart, inRoot-1, inMap);
		root.right = build(postorder, postStart+leftLength, postEnd-1, inorder, inRoot+1, inEnd, inMap);
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] postorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		BTFromPostorderInorder obj = new BTFromPostorderInorder();
		TreeNode root = obj.buildTree(postorder,inorder);
		
		obj.inorderTraversal(root);
		System.out.println();
	}

}
