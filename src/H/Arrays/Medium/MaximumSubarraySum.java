package H.Arrays.Medium;

import java.util.Arrays;

public class MaximumSubarraySum {
	
	public static int maxSubSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int j = 0;
		
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(sum<arr[i]) {
				j=i;
				sum=arr[i];
			}
			max = Math.max(max, sum);
		}
		int tot = 0;
		int k = j;
		while(tot<max) {		
			tot+=arr[k];
			k++;
		}
		int[] sub = new int[k-j];
		for(int i=j;i<k;i++) {
			sub[i-j]= arr[i];
		}
		System.out.println("The sub array is:"+Arrays.toString(sub));
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int sum = maxSubSum(arr);
		
		System.out.println("The maximum sum that we can get from the array is:"+sum);
	}

}
