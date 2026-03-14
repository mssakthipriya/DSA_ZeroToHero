package U.DynamicProgramming.Strings;

public class PrintLongestCommonSubseq {
	
	public static String printLongestCommonSub(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		System.out.println(dp[n][m]);
		
		StringBuilder commStr = new StringBuilder();
		
		int i=n;
		int j=m;
		
		while(i>0 && j>0) {
			if(str1.charAt(i-1)==str2.charAt(j-1)) {
				commStr.append(str1.charAt(i-1));
				i--;
				j--;
			}else if(dp[i][j-1]>dp[i-1][j]) {
				j--;
			}else {
				i--;
			}
		}
		
		return commStr.reverse().toString();
	}
	
	public static void main(String[] args) {
		String str1 = "abcd", str2="bdef";
		
		String commonStr = printLongestCommonSub(str1,str2);
		
		System.out.println(commonStr);
	}

}
