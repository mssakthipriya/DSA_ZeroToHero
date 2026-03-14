package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class PalindromePartitionIITabl {

	public static boolean isPalindrome(String str) {
		int n = str.length();
		int i=0;
		int j=n-1;
		
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
    public static int minCut(String s) {
        int n = s.length();
        
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--) {
        	int minCuts = Integer.MAX_VALUE;
    		for(int k=i;k<n;k++) {
    			if(isPalindrome(s.substring(i, k+1))) {
    				minCuts = Math.min(minCuts, 1+dp[k+1]);
    			}
    		}
    		dp[i] = minCuts;
        }

        
        return dp[0]-1;
    }
	public static void main(String[] args) {
		String s = "bababcbadcede";
		
		int partitions = minCut(s);

		
		System.out.println(partitions);
	}
}
