package U.DynamicProgramming.OneD;

import java.util.Arrays;

public class FrogJumpIIMemo {
	
	public static int solve(int[] height,int k,int index,int[] dp) {
		if(index==0) return 0;
		int min = Integer.MAX_VALUE;
		if(dp[index]!=-1) return dp[index];
		for(int i=1;i<=k;i++) {
			if(index-i>=0) {			   
			   int jump = solve(height,k,index-i,dp)+Math.abs(height[index]-height[index-i]);
			   min = Math.min(min, jump);
			}
		}
		
		return dp[index]=min;
	}
	
	public static int getMinEnergy(int[] height,int k) {
		int index = height.length-1;
		int[] dp = new int[height.length];
		Arrays.fill(dp, -1);
		int min = solve(height,k,index,dp);
		
		return min;
	}
	
	public static void main(String[] args) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
        int k = 2;
        
        int min = getMinEnergy(height,k);
        
        System.out.println(min);
	}

}
