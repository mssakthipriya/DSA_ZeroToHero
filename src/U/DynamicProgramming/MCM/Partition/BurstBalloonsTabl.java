package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class BurstBalloonsTabl {


    public static int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] balloons = new int[n+2];
        balloons[0] = 1;
        balloons[n+1] = 1;
        for(int i=0;i<n;i++) {
        	balloons[i+1]=nums[i];
        }
        
        int[][] dp = new int[n+2][n+2];
        
        for(int i=n;i>=1;i--) {
        	for(int j=1;j<=n;j++) {
        		if(i>j) continue;
        		int maxCoins = Integer.MIN_VALUE;
        		for(int ind = i;ind<=j;ind++) {
        			int cost = (balloons[i-1]*balloons[ind]*balloons[j+1])+dp[i][ind-1]+dp[ind+1][j];

        			maxCoins = Math.max(maxCoins, cost);
        		}
        		
        		dp[i][j] = maxCoins;

        	}
        	

        }
        
        for(int[] ar : dp) {
        	System.out.println(Arrays.toString(ar));
        }
        
        return dp[1][n];
    }
	public static void main(String[] args) {
		int[] balloons = {3,1,5,8};
		
		int coins = maxCoins(balloons);
		
		System.out.println(coins);
	}
} 
