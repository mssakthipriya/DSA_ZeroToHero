package R.BinaryTrees.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurnDuration {
	
	public TreeNode trackParent(TreeNode root,Map<TreeNode,TreeNode> parentTracker,int target) {
		TreeNode start = new TreeNode(-1);
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node.val==target) start = node;
			if(node.left!=null) {
				parentTracker.put(node.left, node);
				q.add(node.left);
			}
			if(node.right!=null) {
				parentTracker.put(node.right, node);
				q.add(node.right);
			}
		}
		
		
		return start;
	}
	
	public int BurnTime(TreeNode root, int target) {
		int timer = 0;
		Map<TreeNode,TreeNode> parentTracker = new HashMap<>();
		TreeNode start = trackParent(root, parentTracker, target);
		
		Queue<TreeNode> que = new LinkedList<>();
		Set<TreeNode> vis = new HashSet<>();
		
		que.offer(start);
		vis.add(start);
		
		while(!que.isEmpty()) {
			int size = que.size();
			boolean flag = false;
			for(int i=0;i<size;i++) {
				TreeNode node = que.poll();
				
				if(node.left!=null && !vis.contains(node.left)) {
					que.add(node.left);
					vis.add(node.left);
					flag = true;
				}
				if(node.right!=null && !vis.contains(node.right)) {
					que.add(node.right);
					vis.add(node.right);
					flag = true;
				}
				if(parentTracker.containsKey(node) && !vis.contains(parentTracker.get(node))) {
					que.add(parentTracker.get(node));
					vis.add(parentTracker.get(node));
					flag = true;
				}
				
			}
			if(flag) timer++;
		}
		
		return timer;
	}
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(7);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);*/
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		BurnDuration obj = new BurnDuration();
		
		int timer = obj.BurnTime(root, 4);
		
		System.out.println(timer);
	}

}
