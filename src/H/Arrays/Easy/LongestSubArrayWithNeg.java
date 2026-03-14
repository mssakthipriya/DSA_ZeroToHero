package H.Arrays.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithNeg {
	
	public static int longestSumSubHash(int[] arr, int sum) {
		int n = arr.length;
		int tot = 0;
		int max = 0;
		Map<Integer,Integer> count = new HashMap<>();
		for(int i=0;i<n;i++) {
			tot+=arr[i];			
			if(tot==sum) {
				max = Math.max(max, i+1);
			}
			
			int rem = tot-sum;
			
			if(count.containsKey(rem)) {
				max =Math.max(max, i-count.get(rem));
			}
			if(!count.containsKey(rem)) {
				count.put(tot, i);
			}
		}

		return max;
	}
	
	public static int longestSumSub(int[] arr, int sum) {
		int n = arr.length;
		int tot = arr[0];
		int max = 0;
		int  i = 0;
		int j = 0;
		while(j<n) {
			
			if(tot>sum && i<=j) {
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
		int[] arr = {-1, 1, 1};
		int sum = 1;
		int length= longestSumSub(arr, sum);
		System.out.println(length);
		System.out.println("Hashing:"+longestSumSubHash(arr, sum));
	}
}
