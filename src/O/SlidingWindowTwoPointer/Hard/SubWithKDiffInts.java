package O.SlidingWindowTwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubWithKDiffInts {
	
	public static int getSubCount(int[] nums,int k) {
		Map<Integer, Integer> map = new HashMap<>();

        int totalCount = 0;
        int start = 0;
        int currCount = 0;

        for (int end = 0; end < nums.length; end++) {
            int rVal = nums[end];
            map.put(rVal, map.getOrDefault(rVal, 0) + 1);
            if (map.get(rVal) == 1) {
                k--;
            }

            if (k < 0) {
                int lVal = nums[start];
                int cnt = map.getOrDefault(lVal, 0);
                if (cnt <= 1) {
                    map.remove(lVal);
                } else {
                    map.put(lVal, cnt - 1);
                }
                start++;
                k++;
                currCount = 0;
            }

            if (k == 0) {
                while (map.getOrDefault(nums[start], 0) > 1) {
                    int lVal = nums[start];
                    int cnt = map.get(lVal);
                    if (cnt <= 1) {
                        map.remove(lVal);
                    } else {
                        map.put(lVal, cnt - 1);
                    }
                    start++;
                    currCount++;
                }
                totalCount += (currCount + 1);
            }
        }
        return totalCount;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1,1,1,2};
		int k = 1;
		
		System.out.println(getSubCount(nums,k));
	}

}
