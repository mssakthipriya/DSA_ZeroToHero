package S.BST.PracticeProblems;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        
        return node.val;
    }
    
    public void pushAll(TreeNode node) {
    	while(node!=null) {
    		st.push(node);
        	node = node.left;
    	}
    }
    
    public boolean hasNext() {
        if(st.isEmpty()) return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		BSTIterator bst = new BSTIterator(root);
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.hasNext());
		System.out.println(bst.next());
		System.out.println(bst.hasNext());
		System.out.println(bst.next());
		System.out.println(bst.hasNext());
		System.out.println(bst.next());
		System.out.println(bst.hasNext());
		
		

	}

}
