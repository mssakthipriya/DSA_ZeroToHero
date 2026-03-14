package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class PalindromePartitionIIMemo {
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
	public static int solve(int i, int j, String s,int[] dp) {
		if(i==j || isPalindrome(s)) return 0;
		if(dp[i]!=-1) return dp[i];
		int minCuts = Integer.MAX_VALUE;
		for(int k=i+1;k<j;k++) {
			if(isPalindrome(s.substring(i, k))) {
				minCuts = Math.min(minCuts, 1+solve(k+1, j, s,dp));
			}
		}
		
		return dp[i] = minCuts;
	}
    public static int minCut(String s) {
        int n = s.length();
        
        int[] dp = new int[n];
        
        Arrays.fill(dp, -1);
        
        return solve(0,n-1,s,dp);
    }
	public static void main(String[] args) {
		String s = "bababcbadcede";
		
		int partitions = minCut(s);

		
		System.out.println(partitions);
	}
}
