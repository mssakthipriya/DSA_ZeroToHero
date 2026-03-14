package O.SlidingWindowTwoPointer.Hard;

public class MinimumWindowSubsequence {
	
	public static String getMinWindowSub(String s1, String s2) {
		int start = 0;
		int end = 0;
		int minStart = -1;
		int minLength = Integer.MAX_VALUE;
		while(end<s1.length()) {
			int j = 0;
			while(end<s1.length()) {
				if(s1.charAt(end)==s2.charAt(j)) {
					j++;
					if(j==s2.length()) break;
				}
				end++;
			}
			if(j<s2.length()) break;
			
			start=end;
			j = s2.length()-1;
			
			while(start>=0) {
				if(s1.charAt(start)==s2.charAt(j)) {
					j--;
					if(j<0) break;
				}
				start--;
			}
			
			if(end-start+1 < minLength) {
				minLength = end-start+1;
				minStart = start;
			}
			
			end = start+1;
		}
		
		return minStart==-1?"":s1.substring(minStart, minStart+minLength);
	}
	public static void main(String[] args) {
		String s1 = "abcdebdde";
		String s2 = "bde";
		
		System.out.println(getMinWindowSub(s1,s2));
	}

}
