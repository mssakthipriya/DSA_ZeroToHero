package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> getFourSum(int[] arr, int target) {
		List<List<Integer>> ans =  new ArrayList<>();
		Arrays.sort(arr);
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(i>0 && arr[i]==arr[i-1]) continue;
			for(int j=i+1;j<n;j++) {
				if(j>i+1 && arr[j]==arr[j-1]) continue;
				int k=j+1;
				int l=n-1;
				while(k<l) {
					int sum=arr[i]+arr[j]+arr[k]+arr[l];
					if(sum<target) {
						k++;
					}else if(sum>target) {
						l--;
					}else {
						List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
						ans.add(temp);
						k++;
						l--;
						
						while(k<l && arr[k]==arr[k-1]) k++;
						while(k<l && arr[l]==arr[l+1]) l--;
					}

				}
			}
		}

		
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {4,3,3,4,4,2,1,2,1,1};
		int target = 9;
		
		List<List<Integer>> sums  = getFourSum(arr,target);
		
		System.out.println(sums.toString());
		
	}


}
