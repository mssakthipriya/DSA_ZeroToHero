package S.BST.PracticeProblems;

import java.util.Stack;

class BSTIteratorII{
	Stack<TreeNode> st;
	boolean reverse;
	
	public BSTIteratorII(TreeNode root, boolean reverse) {
		this.st = new Stack<>();
		this.reverse = reverse;
		pushAll(root);
	}
	
	public boolean hasNext() {
		return !st.isEmpty();
	}
	
	public int next() {
		TreeNode node = st.pop();
		
		if(reverse) pushAll(node.left);
		else pushAll(node.right);
		
		return node.val;
	}
	
	public void pushAll(TreeNode node) {
		while(node!=null) {
			st.push(node);
			if(reverse) {
				node = node.right;
			}else {
				node = node.left;
			}
		}
	}
	
}
public class TwoSumBST {
	
    public boolean findTarget(TreeNode root, int k) {
    	BSTIteratorII small = new BSTIteratorII(root, false);
    	BSTIteratorII large = new BSTIteratorII(root, true);
    	
    	int i = small.next();
    	int j = large.next();
    	
    	while(i<j) {
    		int sum = i+j;
    		if(sum==k) {
    			return true;
    		}else if(sum<k){
    			i = small.next();
    		}else {
    			j = large.next();
    		}
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.left.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.left.left = new TreeNode(8);
		root.right.right = new TreeNode(11);
		
		int k = 16;
		TwoSumBST obj = new TwoSumBST();
		
		System.out.println(obj.findTarget(root, k));
		
	}

}
