package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;

public class NumberOfNGEs {
	
	public static int[] getNGECount(int[] arr, int[] queries) {
		int[] count = new int[queries.length];
		
		for(int i=0;i<queries.length;i++) {
			int ind = queries[i];
			for(int j=ind+1;j<arr.length;j++) {
				if(arr[j]>arr[ind]) {
					count[i]++;
				}
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
		int[] queries = { 0, 5 };//indices
		int[] ans = getNGECount(arr,queries);
		System.out.println(Arrays.toString(ans));
	}

}
