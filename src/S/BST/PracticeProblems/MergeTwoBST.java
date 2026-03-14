package S.BST.PracticeProblems;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {
	
	public List<Integer> mergeBSTs(TreeNode root1, TreeNode root2){
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> mergedList = new ArrayList<>();
		
		inorder(root1, list1);
		inorder(root2, list2);
		
		int i = 0;
		int j = 0;
		
		while(i<list1.size() && j < list2.size()) {
			if(list1.get(i)<list2.get(j)) {
				mergedList.add(list1.get(i));
				i++;
			}else{
				mergedList.add(list2.get(j));
				j++;
			}
		}
		
		while(i<list1.size()) {
			mergedList.add(list1.get(i));
			i++;
		}
		while(j<list2.size()) {
			mergedList.add(list2.get(j));
			j++;
		}
		
		
		return mergedList;
	}
	
	public void inorder(TreeNode root,List<Integer> result){
		if(root == null) return;
		
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
		
	}
	public static void main(String[] args) {
        // Create first BST
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        // Create second BST
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        // Create Solution object
        MergeTwoBST sol = new MergeTwoBST();
        // Merge BSTs
        List<Integer> result = sol.mergeBSTs(root1, root2);
        
        System.out.println(result.toString());
	}

}
