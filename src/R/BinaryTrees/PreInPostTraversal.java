package R.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import R.BinaryTrees.BinaryTreeItr.TNode;


public class PreInPostTraversal {
	TNode root;
	class Pair<K,V>{
	    private final K key;
	    private V value;

	    public Pair(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public K getKey() {
	        return key;
	    }

	    public V getValue() {
	        return value;
	    }
	    
	    public void setValue(V val) {
	    	this.value=val;
	    }
	}
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
	
	public List<List<Integer>> traversals(){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		
        if (root == null) {
            return new ArrayList<>();
        }
        TNode temp = root;
        
		Stack<Pair<TNode, Integer>> stack = new Stack<>();
		stack.push(new Pair<>(temp,1));
		
		while(!stack.isEmpty()) {
			Pair<TNode,Integer> tp = stack.pop();
			if(tp.value==1) {
				pre.add(tp.key.data);
				tp.setValue(2);
				stack.push(tp);
				if(tp.key.left!=null) {
					stack.push(new Pair<>(tp.key.left,1));
				}
			}
			else if(tp.value==2) {
				in.add(tp.key.data);
				tp.setValue(3);
				stack.push(tp);
				if(tp.key.right!=null) {
					stack.push(new Pair<>(tp.key.right,1));
				}
			}else {
				post.add(tp.key.data);
			}
			
		}
		ans.add(in);
		ans.add(pre);
		ans.add(post);
		
		
		System.out.println("Inorder"+in.toString());
		System.out.println("Preorder"+pre.toString());
		System.out.println("Postorder"+post.toString());
		
		return ans;
	}
	
	public void createBinaryTree() {
		TNode one = new TNode(1);
		TNode two = new TNode(2);
		TNode three = new TNode(3);
		TNode four = new TNode(4);
		TNode five = new TNode(5);
		TNode six = new TNode(6);
		TNode seven = new TNode(7);
		
		root = one;
		one.left=two;
		one.right=three;
		two.left=four;
		two.right=five;
		three.left=six;
		three.right=seven;
	}
	
	public static void main(String[] args) {
		PreInPostTraversal pt = new PreInPostTraversal();
		pt.createBinaryTree();
		List<List<Integer>> ans = pt.traversals();
		
		System.out.println(ans.toString());
		
		
	}

}
