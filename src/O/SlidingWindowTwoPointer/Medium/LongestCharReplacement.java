package O.SlidingWindowTwoPointer.Medium;


public class LongestCharReplacement {
	public static int getLongestSub(String s, int k) {
		int[] hash = new int[26];
		int max = 0;
		int start =0;
		int end =0;
		int maxFreq=0;
		while(end<s.length()) {
			hash[s.charAt(end)-'A']++;
			maxFreq = Math.max(maxFreq, hash[s.charAt(end)-'A']);
			
			if((end-start+1)-maxFreq>k) {
				hash[s.charAt(start)-'A']--;
				start++;
			}
			
			max = Math.max(max, end-start+1);
			end++;
		}
		
		return max;
	}
	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		
		System.out.println(getLongestSub(s,k));
	}

}
