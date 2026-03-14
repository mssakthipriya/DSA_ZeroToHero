package U.DynamicProgramming.Strings;

import java.util.Arrays;

public class EditDistanceMemo {
	public static int solve(int i, int j, String w1, String w2,int[][] dp) {
		
		if(i<0) return j+1;
		if(j<0) return i+1;
		
		if(dp[i][j]!=-1) return dp[i][j];
		int count = 0;
		if(w1.charAt(i)==w2.charAt(j)) {
			count = solve(i-1, j-1, w1, w2,dp);
		}else {
			count = 1+Math.min(solve(i, j-1, w1, w2,dp), 
						Math.min(solve(i-1, j, w1, w2,dp), solve(i-1, j-1, w1, w2,dp)));
		}
		
		return dp[i][j] = count;
	}
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] ar: dp) {
        	Arrays.fill(ar, -1);
        }
        
        return solve(n-1,m-1,word1,word2,dp);
    }
    
	public static void main(String[] args) {
		String start = "abcdefg", target = "azced";
		
		int steps = minDistance(start, target);
		
		System.out.println(steps);
	}

}
