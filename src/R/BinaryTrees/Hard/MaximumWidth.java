package R.BinaryTrees.Hard;

import java.util.LinkedList;
import java.util.Queue;
import Z.Utilities.*;

public class MaximumWidth {
	private TreeNode root;
    public int widthOfBinaryTree(TreeNode root) {
       if(root == null) return 0;
       
       int maxWidth = 0;
       
       Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
       q.add(new Pair<>(root, 0));

       while(!q.isEmpty()) {
    	   
    	   int size = q.size();
    	   int minIndex = q.peek().getValue();
    	   int first = 0;
    	   int last = 0;
    	   for(int i=0;i<size;i++) {
        	   Pair<TreeNode,Integer> nodePair = q.poll(); 
        	   TreeNode node = nodePair.getKey();
        	   int currIndex = nodePair.getValue()-minIndex;
        	   if(i==0) first = currIndex;
        	   if(i==size-1) last = currIndex;
        	   
        	   if(node.left!=null) {
        		   q.add(new Pair<>(node.left,2*currIndex+1));
        	   }
        	   if(node.right!=null) {
        		   q.add(new Pair<>(node.right,2*currIndex+2));
        	   }
    	   }
    	   
    	   int currWidth = last-first+1;
    	   maxWidth = Math.max(maxWidth, currWidth);

       }
       
       return maxWidth;
    }
    public void createBinaryTree() {
    	
    	TreeNode one = new TreeNode(1);
    	TreeNode two = new TreeNode(2);
    	TreeNode three = new TreeNode(3);
    	TreeNode nine = new TreeNode(9);
    	TreeNode five = new TreeNode(5);
    	TreeNode six = new TreeNode(6);
    	TreeNode seven = new TreeNode(7);
    	root = one;
    	root.left = three;
    	root.right = two;
    	three.left = five;
    	two.right = nine;
    	five.left = six;
    	nine.left = seven;
    	
    }
	public static void main(String[] args) {
		MaximumWidth obj = new MaximumWidth();
		obj.createBinaryTree();
		
		int max = obj.widthOfBinaryTree(obj.root);
		
		System.out.println(max);
	}

}
