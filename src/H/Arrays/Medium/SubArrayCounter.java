package H.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArrayCounter {
	
	public static int countSubArraysII(int[] arr, int sum) {
		Map<Integer,Integer> map = new HashMap<>();
		int n = arr.length;
		int tot = arr[0];
		int count = 0;
		map.put(0, 1);
		for(int i=0;i<arr.length;i++) {
			tot +=arr[i];
			int remove = tot-sum;
			count+=map.getOrDefault(remove, 0);
			map.put(tot, map.getOrDefault(tot, 0)+1);
		}
		return count;
	}

	public static int countSubArrays(int[] arr, int sum) {
		int n = arr.length;
		int tot = arr[0];
		int count = 0;
		int  i = 0;
		int j = 0;
		while(j<n) {
			
			while(tot>sum && i<=j) {
				tot-=arr[i];
				i++;
			}
			
			if(tot==sum) {
				count++;
			}
			j++;
			if(j<n) {
				tot+=arr[j];
			}

		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 4};
		int sum = 6;
		System.out.println("The maximum number of SubArrays with the given sum is:"+countSubArrays(arr,sum));
		System.out.println("The maximum number of SubArrays with the given sum is:"+countSubArraysII(arr,sum));
	}
}
