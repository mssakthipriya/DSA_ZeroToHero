package S.BST.PracticeProblems;

public class BSTFloor {
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
				root=new Node(data);
				return root;
			}
			if(data<root.data) {
				root.left = insertRec(root.left,data);
			}else {
				root.right = insertRec(root.right,data);
			}
			
			return root;
		}

	
	public int getFloor(Node root,int target) {
		int floor=-1;
		
		Node temp = root;
		while(temp!=null) {
			if(temp.data == target) {
				floor = temp.data;
				return floor;
			}
		
			if(target<temp.data) {
				temp=temp.left;				
			}else {
				floor = temp.data;
				temp=temp.right;
			}
		}
		
		return floor;
	}
	
	public static void main(String[] args) {
		BSTFloor bst = new BSTFloor();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(2);
		bst.insert(6);
		int target = 7;
		int floor = bst.getFloor(bst.root, target);
		System.out.println("the floor of "+target+" is: "+floor);
	}


}
