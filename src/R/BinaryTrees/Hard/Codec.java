package R.BinaryTrees.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
	
	public void inorderTraversal(TreeNode root) {
		if(root == null) return;
		
		inorderTraversal(root.left);
		System.out.print(root.val+" ");
		inorderTraversal(root.right);
	}
	
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) return "";
    	
    	StringBuilder str = new StringBuilder();
    	Queue<TreeNode> q = new LinkedList<>();
       	q.add(root);
    	while(!q.isEmpty()) {
    		TreeNode node = q.poll();
    		
    		if(node==null) {
    			str.append("n ");
    		}else {
    			str.append(node.val+" ");
        		q.add(node.left);
        		q.add(node.right);
    		}
    	}
    	
    	return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        
        String[] values = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        for(int i=1;i<values.length;i++) {
        	TreeNode node = q.poll();
        	
        	if(!values[i].equals("n")) {
        		node.left = new TreeNode(Integer.parseInt(values[i]));
        		q.add(node.left);
        	}
        	
        	i++;
        	
        	if(!values[i].endsWith("n")) {
        		node.right = new TreeNode(Integer.parseInt(values[i]));
        		q.add(node.right);
        	}
        }
        
        return root;
    }
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		Codec obj = new Codec();
		String treeString = obj.serialize(root);
		
		System.out.println(treeString);
		
		TreeNode deRoot = obj.deserialize(treeString);
		
		obj.inorderTraversal(deRoot);
		
	}

}
