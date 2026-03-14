package R.BinaryTrees.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class NodesAtDistanceK {
	
	public void mapParent(TreeNode root, Map<TreeNode,TreeNode> parentMap) {
		if(root==null) return;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.left!=null) {
				parentMap.put(node.left, node);
				q.offer(node.left);
			}
			if(node.right!=null) {
				parentMap.put(node.right, node);
				q.offer(node.right);
			}
		}
		
	}
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        
        if(root==null) return result;
        
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        mapParent(root, parentMap);
        
        Queue<TreeNode> que = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        
        int currLevel = 0;
        que.offer(target);
        vis.add(target);
        
        while(!que.isEmpty()) {
        	int size=que.size();
        	if(currLevel++==k) break;
        	for(int i=0;i<size;i++) {
        		TreeNode node = que.poll();
        		
        		if(node.left!=null && !vis.contains(node.left)) {
        			vis.add(node.left);
        			que.offer(node.left);
        		}
        		if(node.right!=null && !vis.contains(node.right)) {
        			vis.add(node.right);
        			que.offer(node.right);
        		}
        		if(parentMap.containsKey(node) && !vis.contains(parentMap.get(node))) {
        			vis.add(parentMap.get(node));
        			que.offer(parentMap.get(node));
        		}
        	}
        }
        
        while(!que.isEmpty()) {
        	result.add(que.poll().val);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		NodesAtDistanceK obj = new NodesAtDistanceK();
		int k = 2;
		TreeNode target = root.left;
		List<Integer> result = obj.distanceK(root, target, k);
		
		System.out.println(result.toString());

	}
}
