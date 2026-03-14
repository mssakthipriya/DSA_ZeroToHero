package O.SlidingWindowTwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubAtmostK {
	
	public static int getLongestSub(String s, int k) {
		Map<Character,Integer> map = new HashMap<>();
		int length = 0;
		int start = 0;
		int end = 0;
		
		while(end<s.length()) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
			
			while(map.size()>k) {				
				map.put(s.charAt(start), map.get(s.charAt(start))-1);
				if(map.get(s.charAt(start))==0) {
					map.remove(s.charAt(start));
				}
				start++;
			}
			length = Math.max(length,end-start+1);
			end++;
		}
		
		
		return length;
	}
	
	public static void main(String[] args) {
		String s = "aababbcaacc";
		int k = 2;
		System.out.println(getLongestSub(s,k));
	}

}
