package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class BurstBalloonsMemo {

	public static int solve(int i, int j, int[] nums,int[][] dp) {
		
		if(i>j) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		int maxCoins = 0;
		for(int ind = i;ind<=j;ind++) {
			int cost = (nums[i-1]*nums[ind]*nums[j+1])+solve(i, ind-1, nums,dp)+solve(ind+1, j, nums,dp);
			maxCoins = Math.max(maxCoins, cost);
		}
		
		
		return dp[i][j]=maxCoins;
	}
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] balloons = new int[n+2];
        balloons[0] = 1;
        balloons[n+1] = 1;
        for(int i=0;i<n;i++) {
        	balloons[i+1]=nums[i];
        }
        
        int[][] dp = new int[n+2][n+2];
        
        for(int[] ar : dp) {
        	Arrays.fill(ar, -1);
        }
        
        System.out.println(Arrays.toString(balloons));
        
        return solve(1,n,balloons,dp);
    }
	public static void main(String[] args) {
		int[] balloons = {3,1,5,8};
		
		int coins = maxCoins(balloons);
		
		System.out.println(coins);
	}
} 
