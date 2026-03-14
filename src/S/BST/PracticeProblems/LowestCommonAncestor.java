package S.BST.PracticeProblems;

public class LowestCommonAncestor {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	if(root==null) return null;
    	
    	if(p.val <root.val && q.val < root.val) {
    		return lowestCommonAncestor(root.left, p, q);
    	}
    	if(p.val>root.val && q.val > root.val) {
    		return lowestCommonAncestor(root.right, p, q);
    	}
    	
    	return root;
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		LowestCommonAncestor obj = new LowestCommonAncestor();
		
		TreeNode lca = obj.lowestCommonAncestor(root, root.left, root.left.right);
		
		System.out.println(lca.val);
	}

}
