package O.SlidingWindowTwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static String getMinWindowSub(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
	    for (char c : t.toCharArray()) {
	        map.put(c, map.getOrDefault(c, 0) + 1);
	    }

	    int start = 0, end = 0, minLength = Integer.MAX_VALUE, sIndex = -1;
	    int count = 0;
	    
	    while (end < s.length()) {
	        char endChar = s.charAt(end);
	        if (map.containsKey(endChar)) {
	            map.put(endChar, map.get(endChar) - 1);
	            if (map.get(endChar) >= 0) {
	                count++;
	            }
	        }

	        while (count == t.length()) {
	            if (end - start + 1 < minLength) {
	                minLength = end - start + 1;
	                sIndex = start;
	            }

	            char startChar = s.charAt(start);
	            if (map.containsKey(startChar)) {
	                map.put(startChar, map.get(startChar) + 1);
	                if (map.get(startChar) > 0) {
	                    count--;
	                }
	            }
	            start++;
	        }

	        end++;
	    }

	    return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
	}
	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t = "ABC";
		System.out.println(getMinWindowSub(s,t));
	}

}
