package U.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
	
    public static List<Integer> largestDivisibleSubset(int[] nums) {
    	
    	List<Integer> subset = new ArrayList<>();
    	int n = nums.length;
    	Arrays.sort(nums);
    	
    	int[] dp = new int[n];
    	Arrays.fill(dp, -1);
    	int[] parent = new int[n];
    	
    	int lastIndex = 0;
    	int maxLen = 0;
    	
    	for(int i=0;i<n;i++) {
    		parent[i] = i;
    		
    		for(int prevInd = 0; prevInd<i;prevInd++) {
    			if(nums[i]%nums[prevInd]==0 && dp[i]<dp[prevInd]+1) {
    				dp[i] = dp[prevInd]+1;
    				parent[i] = prevInd;
    			}
    			
    			if(dp[i]>maxLen) {
    				maxLen = dp[i];
    				lastIndex = i;
    			}
    		}
    	}
    	
    	int i = lastIndex;
    	
    	while(parent[i]!=i) {
    		subset.add(nums[i]);
    		i=parent[i];
    	}
    	
    	subset.add(nums[i]);

    	
    	return subset;
        
    }
	public static void main(String[] args) {
		int[] nums = {3, 5, 10, 20};
		
		
		List<Integer> subset = largestDivisibleSubset(nums);
		
		System.out.println(subset.toString());
	}

}
