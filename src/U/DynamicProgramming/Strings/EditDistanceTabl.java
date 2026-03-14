package U.DynamicProgramming.Strings;


public class EditDistanceTabl {
	
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++) {
        	dp[i][m] = n-i;
        }
        for(int j=0;j<=m;j++) {
        	dp[n][j] = m-j;
        }
        
        for(int i=n-1;i>=0;i--) {
        	int count=0;
        	for(int j=m-1;j>=0;j--) {
        		if(word1.charAt(i)==word2.charAt(j)) {
        			count = dp[i+1][j+1];
        		}else {
        			count = 1+Math.min(dp[i][j+1], 
        						Math.min(dp[i+1][j], dp[i+1][j+1]));
        		}
        		dp[i][j] = count;
        	}
        }
        
        return dp[0][0];
    }
    
	public static void main(String[] args) {
		String start = "abcdefg", target = "azced";
		
		int steps = minDistance(start, target);
		
		System.out.println(steps);
	}

}
