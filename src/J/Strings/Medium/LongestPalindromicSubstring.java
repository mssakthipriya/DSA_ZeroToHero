package J.Strings.Medium;

public class LongestPalindromicSubstring {

	public static String longestPalindrom(String s) {
		String lps="";

		for(int i=1; i<s.length();i++) {
			//for odd length
			int begin = i;
			int end = i;
			while(s.charAt(begin)==s.charAt(end)) {
				begin--;
				end++;
				if(begin==-1 || end==s.length())
					break;
			}
			String palindrom = s.substring(begin+1, end);
			if(palindrom.length()>lps.length()) {
				lps=palindrom;
			}
			
			//for even length
			begin = i-1;
			end = i;
			while(s.charAt(begin)==s.charAt(end)) {
				begin--;
				end++;
				if(begin==-1 || end==s.length())
					break;
			}
			palindrom = s.substring(begin+1, end);
			if(palindrom.length()>lps.length()) {
				lps=palindrom;
			}
		}
		
		
		return lps;
	}
	
	public static void main(String[] args) {
		String s = "abrbadaadab";
		String sub = longestPalindrom(s);
		System.out.println("The longest plainfromic substring is:"+ sub);
	}
}
