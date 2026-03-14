package L.RecursionPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void getCombination(int[] arr,int target, int index,List<List<Integer>> ans,List<Integer> ds) {
		if(target==0) {
			ans.add(new ArrayList<Integer>(ds));
			return;
		}
		for(int i=index;i<arr.length;i++) {
			if(i>index && arr[i]==arr[i-1])continue;
			if(arr[i]>target) break;
			ds.add(arr[i]);
			getCombination(arr,target-arr[i],i+1, ans,ds);
			ds.remove(ds.size()-1);
			
		}
	}
	public static void main(String[] args) {
		int[] arr = {10,1,2,7,6,1,5};
		int target = 8;
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		getCombination(arr,target,0,ans,new ArrayList<>());
		System.out.println(ans.toString());
	}
}
