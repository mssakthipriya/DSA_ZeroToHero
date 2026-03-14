package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class MinCostToCutStickMemo {
	public static int solve(int i, int j, int[] cuts,int[][] dp) {
		
		if(j-i==1)return 0;
		int min = Integer.MAX_VALUE;
		if(dp[i][j]!=-1) return dp[i][j];
		for(int k=i+1;k<j;k++) {
			int cost = (cuts[j]-cuts[i]) + solve(i, k, cuts,dp)+solve(k, j, cuts,dp);
			min = Math.min(min, cost);
			
		}
		
		return dp[i][j]=min;
	}
    public static int minCost(int n, int[] cuts) {
    	
    	int[] newCuts = new int[cuts.length+2];
    	for(int i=0;i<cuts.length;i++) {
    		newCuts[i] = cuts[i];
    	}
    	int k = newCuts.length;
    	newCuts[k-2] = 0;
    	newCuts[k-1] = n;
    	Arrays.sort(newCuts);
    	
    	System.out.println(Arrays.toString(newCuts));
    	
    	int[][] dp = new int[k][k];
    	for(int[] ar : dp) {
    		Arrays.fill(ar, -1);
    	}	
    	
    	return solve(0,newCuts.length-1 , newCuts,dp);
    }
	public static void main(String[] args) {
		int n = 7;
		int[] cuts = {1, 3, 4, 5};
		
		int cost = minCost(n, cuts);
		
		System.out.println(cost);
	}

}
