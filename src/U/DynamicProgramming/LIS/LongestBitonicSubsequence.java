package U.DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	
	 public static int LongestBitonicSequence(int[] arr) {
		 int n = arr.length;
		 
		 int[] dp1 = new int[n];
		 Arrays.fill(dp1, 1);
		 int[] dp2 = new int[n];
		 Arrays.fill(dp2, 1);
		 
		 int maxLength = 0;
		 
		 for(int i=0;i<n;i++) {
			 for(int prevInd = 0;prevInd<i;prevInd++) {
				 if(arr[i]>arr[prevInd] && dp1[i]<dp1[prevInd]+1) {
					 dp1[i] = dp1[prevInd]+1;
				 }
			 }
		 }
		 
		 for(int i=n-1;i>=0;i--) {
			 for(int prevInd = n-1;prevInd>=i;prevInd--) {
				 if(arr[i]>arr[prevInd] && dp2[i]<dp2[prevInd]+1) {
					 dp2[i] = dp2[prevInd]+1;
				 }
			 }
		 }
		 
		 for(int i=0;i<n;i++) {
			 maxLength = Math.max(maxLength, dp1[i]+dp2[i]-1);
		 }
		 
		 
		 return maxLength;
	 }
	public static void main(String[] args) {
		int[] arr = {5, 1, 4, 2, 3, 6, 8, 7};
		
		int bitonicLength = LongestBitonicSequence(arr);
		
		System.out.println(bitonicLength);
	}

}
