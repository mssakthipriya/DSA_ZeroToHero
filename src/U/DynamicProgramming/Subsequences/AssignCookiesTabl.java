package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class AssignCookiesTabl {
	
    public static int findContentChildren(int[] students, int[] cookies) {
        
    	int n = students.length;
    	int m = cookies.length;
    	
    	Arrays.sort(cookies);
    	Arrays.sort(students);
    	
    	int[][] dp = new int[n+1][m+1];
    	
    	for(int s = n-1;s>=0;s--) {
    		for(int c = m-1;c>=0;c--) {
    			int skip = dp[s][c+1];
    			
    			int take = 0;
    			if(students[s]<=cookies[c]) {
    				take = 1+dp[s+1][c+1];
    			}
    			
    			dp[s][c] = Math.max(skip, take);
    		}
    	}

    	
    	return dp[0][0];
    }
    
    public static void main(String[] args) {
    	int[] students = {1,2,3};
    	int[] cookies = {2,1};
    	
    	int count = findContentChildren(students, cookies);
    	
    	System.out.println(count);
	}

}
