package J.Strings.Easy;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static String getLongestCommonPrefix(String[] strs) {
		String prefix = "";
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		for(int i=0;i<strs[0].length();i++) {
			if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)) {
				prefix+=strs[0].charAt(i);
			}else {
				break;
			}
		}
		
		return prefix;
	}
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		
		String prefix = getLongestCommonPrefix(strs);
		System.out.println("The longest common prefix is:"+ prefix);
	}
}
