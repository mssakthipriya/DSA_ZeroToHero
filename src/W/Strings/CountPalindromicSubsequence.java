package W.Strings;

import java.util.Arrays;

public class CountPalindromicSubsequence {
	public static int countPalindromes(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		int[] next = new int[n];
		int[] prev = new int[n];
		int[] last = new int[26];
		
		Arrays.fill(last, -1);		
		for(int i=0;i<n;i++) {
			prev[i] = last[str.charAt(i)-'a'];
			last[str.charAt(i)-'a'] = i;
		}
		
		Arrays.fill(last, -1);
		for(int i = n-1;i>=0;i--) {
			prev[i] = last[str.charAt(i)-'a'];
			last[str.charAt(i)-'a'] = i;
		}
		
		
		for(int i=0;i<n;i++) {
			dp[i][i] = 1;
		}
		
		for(int len = 2;len<=n;len++) {
			for(int i=0;i<=n-len;i++) {
				int j = i+len-1;
				
				if(str.charAt(i)!=str.charAt(j)) {
					dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
				}else {
                    int low = next[i];
                    int high = prev[j];

                    if (low > high)
                        dp[i][j] = 2 * dp[i+1][j-1] + 2;
                    else if (low == high)
                        dp[i][j] = 2 * dp[i+1][j-1] + 1;
                    else
                        dp[i][j] = 2 * dp[i+1][j-1] - dp[low+1][high-1];
				}
			}
		}
        for(int[] row : dp) {
        	System.out.println(Arrays.toString(row));
        }
		
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		String n = "bccb";
		
		int x = countPalindromes(n);
		
		System.out.println(x);
		
	}

}
