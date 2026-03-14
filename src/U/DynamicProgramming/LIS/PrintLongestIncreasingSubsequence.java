package U.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLongestIncreasingSubsequence {
	
	public static List<Integer> printLongestIncreasingSub(int[] arr){
		List<Integer> longestSub = new ArrayList<>();
		
		int n = arr.length;
		if(n==0) return longestSub;
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] prev = new int[n];
		
		for(int j=1;j<n;j++) {
			int i=0;
			while(i<j) {
				if(arr[i]<arr[j]) {
					dp[j]=dp[i]+1;
					prev[j] = i;
				}
				i++;
			}
		}
		
		//System.out.println(Arrays.toString(dp));
		//System.out.println(Arrays.toString(prev));
		
		int lastInd = -1;
		int length =0;
		for(int i=0;i<n;i++) {
			if(dp[i]>length) {
				length = dp[i];
				lastInd = i;
			}
		}
		
		longestSub.add(arr[lastInd]);

		while(prev[lastInd]!=0) {
			int ind = prev[lastInd];
			longestSub.add(arr[ind]);
			lastInd = ind;
		}
		
		Collections.reverse(longestSub);
		
		return longestSub;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		
		List<Integer> longestSub = printLongestIncreasingSub(arr);
		
		System.out.println(longestSub.toString());
	}

}
