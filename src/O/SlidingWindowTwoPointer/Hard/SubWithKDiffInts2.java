package O.SlidingWindowTwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubWithKDiffInts2 {
	public static int alteastKSubCount(int[] nums,int k) {
		
		Map<Integer,Integer> map = new HashMap<>();
		int count=0;
		int start = 0;
		int end = 0;
		while(end<nums.length) {
			map.put(nums[end],map.getOrDefault(nums[end], 0)+1);
			while(map.size()>k) {
				map.put(nums[start], map.get(nums[start])-1);
				if(map.get(nums[start])==0) {
					map.remove(nums[start]);
				}
				start++;
			}
			count+=(end-start+1);
			end++;
		}
        return count;
	}
	public static int getSubCount(int[] nums,int k) {
		int totalCount = alteastKSubCount(nums,k)-alteastKSubCount(nums,k-1);
        return totalCount;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,1,1,2};
		int k = 1;
		
		System.out.println(getSubCount(nums,k));
	}

}
