package U.DynamicProgramming.Subsequences;

import java.util.Arrays;

public class AssignCookiesMemo {
	public static int getCount(int c, int s, int n, int m,int[] students, int[] cookies, int[][] dp) {
		if(c>=n || s>=m) {
			return 0;
		}
		
		if(dp[s][c]!=-1) return dp[s][c];
		
		int result = 0;
		
		int skip = getCount(c, s+1, n, m, students, cookies, dp);
		
		int take = 0;
		if(students[s]<=cookies[c]) {
			take = 1+getCount(c+1, s+1, n, m, students, cookies, dp);
		}
		result = Math.max(skip, take);
		dp[s][c] = result;
		return result;
	}
    public static int findContentChildren(int[] students, int[] cookies) {
        
    	int n = students.length;
    	int m = cookies.length;
    	
    	Arrays.sort(cookies);
    	Arrays.sort(students);
    	
    	int[][] dp = new int[n][m];
    	
    	for(int[] arr:dp) {
    		Arrays.fill(arr, -1);
    	}
    	
    	return getCount(0, 0, n, m, students, cookies, dp);
    }
    
    public static void main(String[] args) {
    	int[] students = {1,2,3};
    	int[] cookies = {2,1};
    	
    	int count = findContentChildren(students, cookies);
    	
    	System.out.println(count);
	}


}
