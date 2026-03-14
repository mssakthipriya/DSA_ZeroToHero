package U.DynamicProgramming.Strings;




public class DistinctSubsequecesTabl {
	
	public static int getDistinctSub(String s, String t) {
		int n = s.length();
		int m = t.length();
		
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			dp[i][0] = 1;
		}
		for(int i=1;i<=n;i++) {
			int count = 0;
			for(int j=1;j<=m;j++) {
				
				if(s.charAt(i-1)==t.charAt(j-1)) {
					count = dp[i-1][j-1]+dp[i-1][j];
				}else {
					count = dp[i-1][j];
				}				dp[i][j] = count;;
			}
		}

		
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		String s = "babgbag", t = "bag";
		
		int count = getDistinctSub(s,t);
		
		System.out.println(count);
		
	}

}
