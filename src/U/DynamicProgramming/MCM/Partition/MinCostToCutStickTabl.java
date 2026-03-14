package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class MinCostToCutStickTabl {
	
    public static int minCost(int n, int[] cuts) {
    	
    	int[] newCuts = new int[cuts.length+2];
    	for(int i=0;i<cuts.length;i++) {
    		newCuts[i] = cuts[i];
    	}
    	int n2 = newCuts.length;
    	newCuts[n2-2] = 0;
    	newCuts[n2-1] = n;
    	Arrays.sort(newCuts);
    	
    	System.out.println(Arrays.toString(newCuts));
    	
    	int[][] dp = new int[n2][n2];
	
    	
    	for(int i = n2-1;i>=0;i--) {
    		for(int j = i+1;j<n2;j++) {
    			int min = Integer.MAX_VALUE;
    			int cost = 0;
    			for(int k=i+1;k<j;k++) {
    				cost = dp[i][k]+dp[k][j]+(newCuts[j]-newCuts[i]);
    				min = Math.min(min, cost);
    			}
    			
    			dp[i][j] = (min==Integer.MAX_VALUE)?0:min;
    		}
    	}
    	
    	return dp[0][n2-1];
    }
	public static void main(String[] args) {
		int n = 7;
		int[] cuts = {1, 3, 4, 5};
		
		int cost = minCost(n, cuts);
		
		System.out.println(cost);
	}
}
