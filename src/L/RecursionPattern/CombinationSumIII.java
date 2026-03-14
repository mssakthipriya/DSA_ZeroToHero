package L.RecursionPattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void getCombination(int n, int k,int index,int sum, List<List<Integer>> ans,List<Integer> ds) {
		if(ds.size()==k && sum==n) {
		ans.add(new ArrayList<>(ds));
		}
		for(int i=index;i<10;i++) {
			if(ds.size()==k)break;
			ds.add(i);
			getCombination(n,k,i+1,sum+i,ans,ds);
			ds.remove(ds.size()-1);
		}
		
	}
	public static void main(String[] args) {
		int n = 9;
		int k = 3;
		List<List<Integer>> ans = new ArrayList<>();
		
		getCombination(n,k,1,0,ans,new ArrayList<>());
		System.out.println(ans.toString());
	}
}
