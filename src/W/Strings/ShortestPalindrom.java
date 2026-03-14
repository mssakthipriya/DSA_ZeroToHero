package W.Strings;

public class ShortestPalindrom {
	public static int[] buildPrefixTable(String str) {
		int[] lps = new int[str.length()];
		int index = 0;
		for(int i=1;i<str.length();i++) {
			
			while(index>0 && str.charAt(index)!=str.charAt(i)) {
				index = lps[index-1];
			}
			if(str.charAt(index)==str.charAt(i)) {
				index++;
			}
			lps[i] = index;
		}
		
		return lps;
	}
	public static String getshortestPalindrome(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		String combinedStr = s+"#"+rev;
		int[] lps = buildPrefixTable(combinedStr);
		int palLength = lps[combinedStr.length()-1];
		String addon = new StringBuilder(s.substring(palLength)).reverse().toString();
		
		return addon+s;
	}
	public static void main(String[] args) {
		
		String s = "aacecaaa";
		
		String palS = getshortestPalindrome(s);
		
		System.out.println(palS);
	}

}
