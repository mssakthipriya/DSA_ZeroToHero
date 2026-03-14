package U.DynamicProgramming.MCM.Partition;

public class PartitionArrayForMaxSumTabl {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
		for(int index=n-1;index>=0;index--) {
			int maxSum = 0;
			int maxElm = 0;
			for(int i = 1;i<=k && index+i<=n;i++) {
				maxElm = Math.max(maxElm, arr[index+i-1]);
				maxSum = Math.max(maxSum, maxElm*i+dp[index+i]);
			}
			
			dp[index] = maxSum;
		}
        return dp[0];
    }
	public static void main(String[] args) {
		int[] arr = {1,15,7,9,2,5,10};
		int k = 3;
		int maxValue = maxSumAfterPartitioning(arr, k);
		
		System.out.println(maxValue);
	}

}
