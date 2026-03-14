package R.BinaryTrees.Hard;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
	TreeNode root;
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public void createBTree() {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
	}
	
	public boolean getPath(TreeNode root, int target, List<Integer> result) {
		if(root==null) return false;
		
		result.add(root.val);
		if(root.val == target) return true;
		
		if(getPath(root.left, target, result) || getPath(root.right, target, result)) {
			return true;
		}
		
		result.remove(result.size()-1);
		return false;
	}
	public List<Integer> getRootToNodePath(TreeNode root, int target){
		List<Integer> result = new ArrayList<>();
		
		if(root==null) return result;
		getPath(root,target,result);
		
		System.out.println(result.size());
		
		return result;
	}
	
	public static void main(String[] args) {
		RootToNodePath btree = new RootToNodePath();
		btree.createBTree();
		int target = 7;

		List<Integer> result = btree.getRootToNodePath(btree.root, target);

		System.out.println(result.toString());
		
	}
}
