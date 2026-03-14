package O.SlidingWindowTwoPointer.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSub {

	public static int getLongestNonRepeatSub(String s) {
		int max =0;
		
		Map<Character,Integer> map = new HashMap<>();
		int start = 0;
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				start = map.get(s.charAt(i))+1;				
			}
			map.put(s.charAt(i), i);
			int length = (i-start)+1;
			System.out.println(s.substring(start,i+1));
			max = Math.max(max, length);
		}
		
		return max;
	}
	public static void main(String[] args) {
		String s ="abcabcbb";
		
		System.out.println("The longest non repeating substring is of length:"+getLongestNonRepeatSub(s));
	}
}
