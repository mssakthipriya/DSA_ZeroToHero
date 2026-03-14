package U.DynamicProgramming.Strings;

public class WildcardMatchingTabl {

    public static boolean isMatch(String p, String s) {
        int n = p.length();
        int m = s.length();
        
        boolean[][] dp = new boolean[n+1][m+1];
        dp[n][m] = true;
        
        for(int i=n-1;i>=0;i--) {
        	if(p.charAt(i)=='*') {
        		dp[i][m]=true;
        	}
        }
        for(int i=n-1;i>=0;i--) {
        	for(int j=m-1;j>=0;j--) {
        		if(s.charAt(j)==p.charAt(i) || p.charAt(i)=='?') {
        			dp[i][j] = dp[i+1][j+1];
        		}else if(p.charAt(i)=='*') {
        			dp[i][j] = dp[i+1][j]||dp[i][j+1];
        		}else {
        			dp[i][j]=false;
        		}
        		
        	}
        }
        
        return dp[0][0];
    }

	public static void main(String[] args) {
		String S1 = "ab*cd", S2 = "abdefcd";
		
		boolean match = isMatch(S1, S2);
		
		System.out.println(match);
	}
}
