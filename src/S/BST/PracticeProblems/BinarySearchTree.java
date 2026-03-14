package S.BST.PracticeProblems;

public class BinarySearchTree {
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		
		TNode(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public void insert(int data){
		root = insertRecursive(root,data);
	}
	public TNode insertRecursive(TNode root, int data) {
		if(root==null) {
			root = new TNode(data);
			return root;
		}
		
		if(data<root.data) {
			root.left = insertRecursive(root.left,data);
		}else {
			root.right = insertRecursive(root.right,data);
		}
		
		return root;
	}
	
	public TNode deleteNode(TNode root,int data) {
		if(root == null) return root;
		
		if(data<root.data) {
			root.left = deleteNode(root.left,data);
		}else if(data>root.data) {
			root.right = deleteNode(root.right,data);
		}else {
			if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
				return root.left;
			}else {
				TNode temp = getSuccessor(root);
				root.data = temp.data;
				root.right = deleteNode(root.right,temp.data);
			}
		}
		return root;
	}
	
	public TNode getSuccessor(TNode node) {
		node = node.right;
		while(node!=null && node.left!=null) {
			node=node.left;
		}
		
		return node;
	}
	public void inOrder(TNode root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(8);
		bst.insert(7);
		bst.insert(10);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		bst.insert(4);
		bst.insert(5);
		bst.insert(14);
		bst.insert(13);
		bst.deleteNode(bst.root, 8);
		bst.inOrder(bst.root);
	}

}
