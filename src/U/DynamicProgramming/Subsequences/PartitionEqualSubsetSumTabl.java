package U.DynamicProgramming.Subsequences;

public class PartitionEqualSubsetSumTabl {
	
    public static  boolean canPartition(int[] nums) {
        
    	int n = nums.length;
    	int sum = 0;
    	for(int i=0;i<n;i++) {
    		sum+=nums[i];
    	}
    	
    	if(sum%2==1) return false;
    	else sum = sum/2;
    	
    	boolean dp[][] = new boolean[n][sum+1];
    	
    	for(int i=0;i<n;i++) {
    		dp[i][0] = true;
    	}
    	
    	if(nums[0]<=sum) {
    		dp[0][nums[0]] = true;
    	}
    	
    	for(int i=1;i<n;i++) {
    		for(int j=1;j<=sum;j++) {
    			if(j<nums[i]) {
    				dp[i][j] = dp[i-1][j];
    			}else {
    				dp[i][j] = dp[i-1][j]|| dp[i-1][j-nums[i]];
    			}
    		}
    	}
    	return dp[n-1][sum];
    }

	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		
		boolean check = canPartition(nums);
		
		System.out.println(check);
		
	}
}
