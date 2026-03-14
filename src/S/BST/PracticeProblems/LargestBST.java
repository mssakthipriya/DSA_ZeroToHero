package S.BST.PracticeProblems;




public class LargestBST {
	
	class NodeValues{
		int minValue;
		int maxValue;
		int size;
		
		
		public NodeValues(int minValue,int maxValue,int size) {
			this.minValue = minValue;
			this.maxValue = maxValue;
			this.size = size;
		}
	}
	
    public NodeValues maxSumBSTHelper(TreeNode root) {
        if(root == null) {
        	return new NodeValues(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        } 
        
        NodeValues left = maxSumBSTHelper(root.left);
        NodeValues right = maxSumBSTHelper(root.right);
        
        if(left.maxValue < root.val && root.val < right.minValue) {
            return new NodeValues(
                Math.min(root.val, left.minValue),
                Math.max(root.val, right.maxValue),
                left.size + right.size + 1
            );
        }
        
        return new NodeValues(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.size, right.size)
        );
    }
	
    public int maxSumBST(TreeNode root) {
        return maxSumBSTHelper(root).size;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(4);
		root.right.right.right = new TreeNode(6);
		
		LargestBST obj = new LargestBST();
		
		System.out.println(obj.maxSumBST(root));
	}

}
