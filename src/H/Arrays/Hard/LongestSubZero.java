package H.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubZero {
	
	public static int longestSub(int[] arr) {
		int max = 0;
		int sum = 0;
		Map<Integer,Integer> map = new HashMap<>();		
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			if(sum==0) {
				max = Math.max(max, i+1);
			}else {
			if(map.containsKey(sum)) {
				//If the same running sum was seen at some earlier index j, it means the subarray between j+1 and i has sum = 0.
				max = Math.max(max, i-(map.get(sum)));
			}else {

				map.put(sum, i);
			}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {9, -3, 3, -1, 6, -5};
		int length = longestSub(arr);
		System.out.println("The length of the longest subarray that sum to zero is:"+length);
	}
}
