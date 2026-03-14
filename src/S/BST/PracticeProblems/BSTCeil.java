package S.BST.PracticeProblems;

public class BSTCeil {
	Node root;
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void insert(int data) {
		root = insertRec(root,data);
		
	}
	public Node insertRec(Node root,int data) {		
		if(root==null) {
			root = new Node(data);
			return root;
		}
		
		if(data<root.data) {
			root.left = insertRec(root.left,data);
		}else {
			root.right = insertRec(root.right,data);
		}
		
		return root;
	}
	public int getCeil(Node root,int target) {
		int ceil = -1;
		Node temp = root;
		while(temp!=null) {
			if(temp.data==target) {
				ceil = temp.data;
			}
			if(target<temp.data) {
				ceil = temp.data;
				temp = temp.left;
			}else {
				temp=temp.right;
			}
		}
		return ceil;
	}
	public static void main(String[] args) {
		BSTCeil bst = new BSTCeil();
		bst.insert(10);
		bst.insert(5);
		bst.insert(13);
		bst.insert(3);
		bst.insert(6);
		bst.insert(11);
		bst.insert(14);
		bst.insert(2);
		bst.insert(4);
		bst.insert(9);
		
		//System.out.println( bst.root.left.left.data);
		int target = 8;
		int ceil = bst.getCeil(bst.root, target);
		System.out.println("The ceiling of "+target+" is: "+ceil);
	}

}
