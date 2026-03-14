package J.Strings.Easy;

public class AnagramChecker {

    public static boolean isAnagram(String s, String t) {
    	if(s.length()!= t.length())
    		return false;
    	int[] count = new int[26];
    	for(int i=0;i<s.length();i++) {
    		count[s.charAt(i)-'a']++;
    		count[t.charAt(i)-'a']--;
    	}
    	for(int a : count) {
    		if(a!=0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		
		boolean flag = isAnagram(s,t);
		
		if(flag) {
			System.out.println("The string are anagrams");
		}else {
			System.out.println("The strings are not anagrams");
		}
		
	}
}
