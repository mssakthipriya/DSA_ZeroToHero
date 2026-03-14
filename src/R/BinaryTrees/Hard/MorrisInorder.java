package R.BinaryTrees.Hard;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorder {
	
	public List<Integer> inorder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		
		TreeNode curr = root;
		
		while(curr!=null) {
			
			if(curr.left==null) {
				result.add(curr.val);
				curr = curr.right;
			}else {
				
				TreeNode prev = curr.left;
				while(prev.right!=null && prev.right!=curr) {
					prev = prev.right;
				}
				
				if(prev.right==null) {
					prev.right = curr;
					curr = curr.left;
				}else {
					prev.right = null;
					result.add(curr.val);
					curr = curr.right;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(9);
		root.left.left.right.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		
		MorrisInorder obj = new MorrisInorder();
		
		List<Integer> result = obj.inorder(root);
		
		System.out.println(result.toString());
		
	}

}
