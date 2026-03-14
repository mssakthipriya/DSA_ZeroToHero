package L.RecursionPattern;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumI {
	
	public static void getSubSetSum(int[] arr,int index,int sum,List<Integer> ans) {
		if(index==arr.length) {
			ans.add(sum);
			return;
		}
		

		getSubSetSum(arr,index+1,sum+arr[index],ans);
		getSubSetSum(arr,index+1,sum,ans);
		ans.sort(null);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,2};
		List<Integer> ans = new ArrayList<>();
		getSubSetSum(arr,0,0,ans);
		System.out.println(ans);
	}

}
