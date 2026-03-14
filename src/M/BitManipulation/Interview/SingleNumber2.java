package M.BitManipulation.Interview;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber2 {
	public static List<Integer> getOddBalls(int[] nums){
			List<Integer> ans  = new ArrayList<>();
			int rem = 0;
			for(int i=0;i<nums.length;i++) {
				rem = rem^nums[i];
			}
			System.out.println(rem);
			int index = (rem&(rem-1))^rem;
			System.out.println(index);
			int bucket1  = 0;
			int bucket2  = 0;
			
			for(int i=0;i<nums.length;i++) {
				if((nums[i]&index)==0) bucket1=bucket1^nums[i];
				else bucket2=bucket2^nums[i];
			}
			
			ans.add(bucket1);
			ans.add(bucket2);
			return ans;
	}
	public static void main(String[] args) {
		int[] nums = {2,4,2,14,3,7,7,3};
		
		List<Integer> oddBalls = getOddBalls(nums);
		
		System.out.println(oddBalls.toString());
	}

}
