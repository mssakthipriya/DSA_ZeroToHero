package S.BST.PracticeProblems;

public class KthSmallestLargestElement {
	
	int k;
	int smallest;
	int largest;

    public int kthSmallest(TreeNode root, int k) {        
        this.k = k;
        this.smallest = -1;
        
        inorder(root);
        
        return smallest;
    }
    
    public void inorder(TreeNode root) {
    	if(root == null) return;
    	
    	inorder(root.left);
    	if(--k==0) {
    		smallest = root.val;
    		return;
    	}
    	inorder(root.right);
    }
    
    public int kthLargest(TreeNode root, int k) {
       this.k = k;
       this.largest = -1;
       
       reverseInorder(root);
        
        return largest;
    }
    
    
    public void reverseInorder(TreeNode root) {
    	if(root == null) return;
    	
    	reverseInorder(root.right);
    	if(--k==0) {
    		largest = root.val;
    		return;
    	}
    	reverseInorder(root.left);
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		int k = 3;
		KthSmallestLargestElement obj = new KthSmallestLargestElement();
		
		int smallest = obj.kthSmallest(root, k);
		
		System.out.println("The kth smallest element is:"+ smallest);
		
		int largest = obj.kthLargest(root, k);
		
		System.out.println("the kth largest element is:"+largest);
		
		
	}

}
