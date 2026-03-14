package S.BST.PracticeProblems;

public class RecoverBST {
	TreeNode first;
	TreeNode middle;
	TreeNode last;
	TreeNode prev;
	
	public void inorderPrint(TreeNode root) {
		if(root == null) return;
		inorderPrint(root.left);
		System.out.print(root.val);
		inorderPrint(root.right);
	}
	public void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		
		if(prev!=null && prev.val > root.val) {
			if(first==null) {
				first = prev;
				middle = root;
			}else {
				last = root;
			}
		}
		prev = root;
		inorder(root.right);
	}
	
    public void recoverTree(TreeNode root) {
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inorder(root);
        
        if(first!=null && last!=null) {
        	int value = last.val;
        	last.val = first.val;
        	first.val = value;
        }else if(first!=null && middle!=null) {
        	int value = middle.val;
        	middle.val = first.val;
        	first.val = value;       	
        }
        
        
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		
		RecoverBST obj = new RecoverBST();
		
		obj.inorderPrint(root);
		System.out.println();
		obj.recoverTree(root);
		obj.inorderPrint(root);
		System.out.println();
		
		
	}

}
