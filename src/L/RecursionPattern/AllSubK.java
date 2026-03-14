package L.RecursionPattern;

import java.util.ArrayList;
import java.util.List;

public class AllSubK {
	public static void getSubK(int[] arr, int k,List<Integer> ans, int i ,int sum) {
		if(i==arr.length) {
			if (sum==k) {
			System.out.println(ans);
			}
			return;
		}
		ans.add(arr[i]);
		getSubK(arr,k,ans,i+1,sum+arr[i]);
		ans.remove(ans.size()-1);
		getSubK(arr,k,ans,i+1,sum);
		
		
	}
	public static void main(String[] args) {
		int[] arr = {1,2,1};
		int k = 2;
		List<Integer> ans = new ArrayList<>();
		getSubK(arr,k,ans,0,0);
	}

}
