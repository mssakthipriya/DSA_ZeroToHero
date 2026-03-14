package S.BST.PracticeProblems;


public class MaxSumBST {
	
	class NodeValues{
		int minValue;
		int maxValue;
		int sum;
		boolean isBST;
		
		
		public NodeValues(int minValue,int maxValue,int sum, boolean isBST) {
			this.minValue = minValue;
			this.maxValue = maxValue;
			this.sum = sum;
			this.isBST = isBST;
		}
	}
	
	int maxSum = 0;
	
    public NodeValues maxSumBSTHelper(TreeNode root) {
        if(root == null) {
        	return new NodeValues(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        } 
        
        NodeValues left = maxSumBSTHelper(root.left);
        NodeValues right = maxSumBSTHelper(root.right);
        
        if(left.isBST && right.isBST && left.maxValue< root.val && root.val < right.minValue) {
        	int currSum = left.sum+right.sum+root.val;
        	maxSum = Math.max(maxSum, currSum);
        	
            return new NodeValues(
                Math.min(root.val, left.minValue),
                Math.max(root.val, right.maxValue),
                currSum,
                true
            );
        }
        
        return new NodeValues(0,0,0,false);
    }
	
    public int maxSumBST(TreeNode root) {

    	maxSumBSTHelper(root);
    	
    	return maxSum;
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
		
		MaxSumBST obj = new MaxSumBST();
		
		System.out.println(obj.maxSumBST(root));
	}

}
