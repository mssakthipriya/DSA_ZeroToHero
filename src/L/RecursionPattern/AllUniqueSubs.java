package L.RecursionPattern;

import java.util.ArrayList;
import java.util.List;

public class AllUniqueSubs {
	public static void getSubs(int[] nums,int index,List<List<Integer>> ans, List<Integer> ds) {
		if(index==nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		ds.add(nums[index]);
		getSubs(nums,index+1,ans,ds);
		ds.remove(ds.size()-1);	
		getSubs(nums,index+1,ans,ds);
	}
	public static List<List<Integer>> getUniqueSubs(int[] nums){
		List<List<Integer>> ans = new ArrayList<>();		
		getSubs(nums,0,ans,new ArrayList<>());
		
		return ans;
	} 
	public static void main(String[] args) {
		int[] nums = {1,1,2,3};
		
		List<List<Integer>> subsets = getUniqueSubs(nums);
		
		System.out.println(subsets.toString());
	}

}
