package R.BinaryTrees.Medium;

public class TwinTreeCheck {
	TNode root;
	
	class TNode{
		int data;
		TNode left;
		TNode right;
		TNode(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	public void createBinaryTree() {
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		TNode eight = new TNode(8);
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
		seven.right=eight;
	}
	public void createBinaryTree2() {
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		TNode eight = new TNode(8);
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
		//seven.right=eight;
	}
	
	public boolean twinCheck(TNode root1,TNode root2) {
		if(root1==null&&root2==null) return true;
		if(root1==null||root2==null) return false;
		
		boolean lCheck = twinCheck(root1.left,root2.left);
		boolean rCheck = twinCheck(root1.right,root2.right);
		
		
		return root1.data==root2.data && lCheck && rCheck;
	}
	
	public static void main(String[] args) {
		TwinTreeCheck bt1 = new TwinTreeCheck();
		TwinTreeCheck bt2 = new TwinTreeCheck();
		
		bt1.createBinaryTree();
		bt2.createBinaryTree2();
		
		boolean check = bt1.twinCheck(bt1.root,bt2.root);
		
		System.out.println(check);
		
	}

}
