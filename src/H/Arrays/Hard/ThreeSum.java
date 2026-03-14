package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public static List<List<Integer>> getThreeSumII(int[] arr){
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(i!=0 && arr[i]==arr[i-1]) continue;
			int j=i+1;
			int k=arr.length-1;
			while(j<k) {
				int sum = arr[i]+arr[j]+arr[k];
				if(sum<0) {
					j++;
				}else if(sum>0) {
					k--;
				}else {
					List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
					ans.add(temp);
					j++;
					k--;
					while(j<k && arr[j]==arr[j-1]) j++;
					while(j<k && arr[k]==arr[k+1]) k--;
				}

			}
		}
		
		return ans;
	}
	
	public static List<List<Integer>> getThreeSum(int[] arr){
		Set<List<Integer>> st = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			Set<Integer> hashset = new HashSet<>();
			for(int j=i+1;j<arr.length;j++) {
				int k = -(arr[i]+arr[j]);
				if(hashset.contains(k)) {
				List<Integer> temp = Arrays.asList(arr[i],arr[j],k);
				temp.sort(null);
				st.add(temp);
				}
				hashset.add(arr[j]);
			}
		}
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>(st);
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr= {-1,0,1,2,-1,-4};
		List<List<Integer>> ans = getThreeSum(arr);
		List<List<Integer>> ans2 = getThreeSumII(arr);
		System.out.println(ans.toString());
		System.out.println(ans2.toString());
		
	}
}
