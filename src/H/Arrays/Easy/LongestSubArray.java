package H.Arrays.Easy;

import java.util.Arrays;

public class LongestSubArray {
	
	public static int longestSumSub(int[] arr, int sum) {
		int n = arr.length;
		int tot = arr[0];
		int max = 0;
		int  i = 0;
		int j = 0;
		while(j<n) {
			
			while(tot>sum && i<=j) {
				tot-=arr[i];
				i++;
			}
			
			if(tot==sum) {
				max = Math.max(max, (j-i)+1);
			}
			j++;
			if(j<n) {
				tot+=arr[j];
			}

		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,5,1,9};
		int sum = 10;
		int length= longestSumSub(arr, sum);
		System.out.println(length);
	}
}
