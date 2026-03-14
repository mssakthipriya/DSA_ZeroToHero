package R.BinaryTrees.Hard;

public class CompleteNodesCount {
	
	
    public int countNodes(TreeNode root) {
       int leftDepth = getLeftDepth(root);
       int rightDepth = getRightDepth(root);
       
       //count = 2^n - 1
       if(leftDepth == rightDepth) {
    	   return (int)Math.pow(2,leftDepth)-1;
       }else {
    	   return 1+ countNodes(root.left)+countNodes(root.right);
       }
    }
	public int getLeftDepth(TreeNode root) {
		int depth = 0;
		while(root!=null) {
			root = root.left;
			depth++;
		}
		return depth;
	}
	public int getRightDepth(TreeNode root) {
		int depth = 0;
		while(root!=null) {
			root = root.right;
			depth++;
		}
		return depth;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		
		CompleteNodesCount obj = new CompleteNodesCount();
		
		int nodeCount = obj.countNodes(root);
		
		System.out.println(nodeCount);
	}

}
