package U.DynamicProgramming.Subsequences;

public class CountPartitionsDiff {

	public static int countPartitions(int[] arr, int d) {
		int n = arr.length;
		
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		
		if(d>sum || (sum+d)%2!=0) return 0;
		
		int k = (sum+d)/2;
		
		int[] dp = new int[k+1];		
		dp[0] = 1;
		if (arr[0] <= k) dp[arr[0]] += 1;
		
		for(int i=1;i<n;i++) {
			int[] curr = new int[k+1];
			curr[0] = 1;
			for(int j=0;j<=k;j++) {
				int notTake = dp[j];
				
				int take = 0;				
				if(j>=arr[i]) {
					take = dp[j-arr[i]];
				}
				
				curr[j] = take+notTake;
			}
			dp = curr;
		}
		
		return dp[k];
	}
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3};
		int d = 1;
		
		int count = countPartitions(arr, d);
		
		System.out.println(count);
	}
}
