package S.BST;

public class BinarySearchTree {
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		
		TNode(int data){
			this.data=data;
			left = null;
			right = null;
		}
	}
	
	public 	void insert(int data) {
		root = insert(root,data);
	}	
	public 	TNode insert(TNode root,int data) {
		if(root==null) {
			root = new TNode(data); 
			return root;			
		}
		if(data<root.data) {
			root.left=insert(root.left,data);
		}else {
			root.right=insert(root.right,data);
		}
		
		return root;
	}
	
	public int getMin() {
		if(root==null) return -1;
		int min = root.data;
		TNode temp = root;
		while(temp!=null) {
			min = temp.data;
			temp=temp.left;
		}
		
		return min;
	}
	
	public int getMax() {
		if(root==null) return -1;
		int max = root.data;
		TNode temp = root;
		while(temp!=null) {
			max = temp.data;
			temp=temp.right;
		}
		
		return max;
	}
	public boolean recursiveSearch(TNode root,int data) {
		if(root==null) return false;
		if(root.data==data) return true;
		
		if(data<root.data)
			return recursiveSearch(root.left,data);
		else
			return recursiveSearch(root.right,data);
	}
	public boolean searchII(int data) {
		return recursiveSearch(root,data);
	}
	
	public int search(int data) {	
		TNode temp= root;
		while(temp!=null && temp.data!=data) {
			temp = data<temp.data?temp.left:temp.right;
		}
		if(temp==null) return -1;
		return temp.data;
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
		
		System.out.println(bst.root.data);
		System.out.println(bst.root.left.data);
		System.out.println(bst.root.right.data);
		
		System.out.println("Min:"+bst.getMin());
		System.out.println("Max:"+bst.getMax());
		
		
		System.out.println(bst.search(11));
		System.out.println(bst.search(1));
		System.out.println(bst.search(13));
	}

}
