package O.SlidingWindowTwoPointer.Medium;

public class SubWithAllChar {
	
	public static int getSubCount(String s) {
		int[] freq = new int[3];
		int count = 0;
		int start=0;
		int end = 0;
		for(end=0;end<s.length();end++) {
			freq[s.charAt(end)-'a']++;
			
			while(allChar(freq)) {
				count+=s.length()-end;
				freq[s.charAt(start)-'a']--;
				start++;
			}
		}
		
		return count;
	}
	
	public static boolean allChar(int[] freq) {
		if(freq[0]>0 && freq[1]>0 && freq[2]>0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String s = "abcabc";
		
		System.out.println(getSubCount(s));
	}

}
