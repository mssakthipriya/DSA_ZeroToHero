package H.Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] ans = {-1,-1};
		Map<Integer,Integer> sum = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			int rem = target-nums[i];
			if(sum.containsKey(rem)) {
				ans[0] = sum.get(rem);
				ans[1] = i;
				
			}else {
				sum.put(nums[i], i);
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {2,6,5,8,11};
		int target = 13;
		
		int[] ans = twoSum(arr, target);
		System.out.println("The addends are :"+ Arrays.toString(ans));
	}
}
