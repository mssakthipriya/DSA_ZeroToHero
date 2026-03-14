package U.DynamicProgramming.Subsequences;



public class TargetSumTabl {

    public static int findTargetSumWays(int[] nums, int target) {
    	int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
        	sum+=nums[i];
        }
        
        if((sum-target)<0 || (sum-target)%2!=0) return 0;
        
        int targetSum = (sum-target)/2;
        
        int[][] dp = new int[n][targetSum+1];
        
        dp[0][0] = 1;

        if(nums[0] <= targetSum) {
            dp[0][nums[0]] = 1;
        }

        
        for(int ind=1;ind<n;ind++) {
        	for(int tar = 0;tar<=targetSum;tar++) {
        		int notTake = dp[ind-1][tar];
        		int take = 0;
        		
        		if(tar>=nums[ind]) {
        			take = dp[ind-1][tar-nums[ind]];
        		}
        		
        		dp[ind][tar]=take+notTake;
        	}
        }
        
        return dp[n-1][targetSum];
    }
    
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		int target = 3;
		
		int ways = findTargetSumWays(nums, target);
		
		System.out.println(ways);
	}
}
