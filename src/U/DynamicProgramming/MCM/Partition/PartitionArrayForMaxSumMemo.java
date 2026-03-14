package U.DynamicProgramming.MCM.Partition;

import java.util.Arrays;

public class PartitionArrayForMaxSumMemo {
	
	public static int solve(int index, int k, int[] arr, int[] dp) {
		int n = arr.length;
		if(index==n) return 0;
		if(dp[index]!=-1) return dp[index];
		int maxSum = 0;
		int maxElm = 0;
		for(int i = 1;i<=k && index+i<=n;i++) {
			maxElm = Math.max(maxElm, arr[index+i-1]);
			maxSum = Math.max(maxSum, maxElm*i+solve(index+i, k, arr,dp));
		}
		
		
		return dp[index] = maxSum;
	}
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, k, arr,dp);
    }
	public static void main(String[] args) {
		int[] arr = {1,15,7,9,2,5,10};
		int k = 3;
		int maxValue = maxSumAfterPartitioning(arr, k);
		
		System.out.println(maxValue);
	}
}
