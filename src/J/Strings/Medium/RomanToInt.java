package J.Strings.Medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	
	public static int romanToInt(String str) {		
		Map<Character,Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int ans =map.get(str.charAt(0));
		for(int i=1;i<str.length();i++) {
			if(map.get(str.charAt(i-1))< map.get(str.charAt(i))) {
				ans+=(map.get(str.charAt(i))-(2*map.get(str.charAt(i-1))));
			}else {
				ans+=map.get(str.charAt(i));
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		String str = "MCMXCIV";
		int ans = romanToInt(str);
		
		System.out.println("The integer corresponding to "+str+" is:"+ans);
	}
}
