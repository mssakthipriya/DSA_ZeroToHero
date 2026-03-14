package U.DynamicProgramming.Subsequences;

public class SubsetSumTargetTabl {
	
	public static boolean isSubsetSum(int[] arr, int k) {
		
		int n = arr.length;
		
		boolean dp[][] = new boolean[n][k+1];
		
		for(int i=0;i<n;i++) {
			dp[i][0] = true;
		}
		
		if(arr[0] <= k) {
			dp[0][arr[0]] = true;
		}
		
		for(int i =1;i<n;i++) {
			for(int j=1;j<=k;j++) {

				if(j<arr[i]) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
				}
				
				
			}
		}
		
		
		
		return dp[n-1][k];
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 5, 2};
		int k = 6;
		
		boolean check = isSubsetSum(arr,k);
		
		System.out.println(check);
	}


}
