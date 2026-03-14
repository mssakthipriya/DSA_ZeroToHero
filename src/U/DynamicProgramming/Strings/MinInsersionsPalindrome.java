package U.DynamicProgramming.Strings;

public class MinInsersionsPalindrome {
	public static int getLPS(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[n][m];
	}
	public static int longestPalindrome(String s) {
		StringBuilder s2 = new StringBuilder(s);
		return getLPS(s, s2.reverse().toString());
	}
	
    public static int minInsertions(String s) {
        int length = s.length();
        int palindromeLength = longestPalindrome(s);
         return length - palindromeLength;
     }
	public static void main(String[] args) {
		String s = "abcaa";
		
		int length = minInsertions(s);
		
		System.out.println(length);
	}

}
