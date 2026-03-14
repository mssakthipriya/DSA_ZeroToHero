package H.Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class LonelyNumber {
	public static int singleNumber(int[] nums) {
		int ans = 0;
		Map<Integer,Integer> counter = new HashMap<>();
		for(int e : nums) {
			if(counter.containsKey(e)) {
				counter.put(e, counter.get(e)+1);
			}else {
				counter.put(e, 1);
			}
		}

		for(Map.Entry<Integer, Integer> eSet: counter.entrySet()) {
			if(eSet.getValue()==1) {
				ans = eSet.getKey();
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {2,2,1};
		System.out.println("The lonely number in this array is:"+singleNumber(arr));
	}
}
