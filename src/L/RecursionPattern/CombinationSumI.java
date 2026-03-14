package L.RecursionPattern;

import java.util.ArrayList;
import java.util.List;


public class CombinationSumI {

	public static void getCombination(int[] arr,int target,int index,int sum,List<List<Integer>> ans,List<Integer> ds) {
		if(index==arr.length) {
			if(sum==target) {
				ans.add(new ArrayList <>(ds));			
			}
			return;
		}
		if(sum<=target) {
			ds.add(arr[index]);
			getCombination(arr,target,index,sum+arr[index],ans,ds);
			ds.remove(ds.size()-1);
		}
		getCombination(arr,target,index+1,sum,ans,ds);
	}
	public static void main(String[] args) {
		int[] arr = {2,3,6,7};
		int target = 7;
		List<List<Integer>> ans = new ArrayList<>();
		getCombination(arr,target,0,0,ans,new ArrayList<Integer>());
		System.out.println(ans.toString());
	}
}
