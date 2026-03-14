package E.BasicRecursion;

public class PalindromeChecker {
	
	public static boolean checkPalindrome(String a) {
		int first = 0;
		int last = a.length()-1;
		
		return reverseString(a,first,last);
	}
	
	public static boolean reverseString(String s,int first,int last) {
		if(first>last)
			return true;
		if(s.charAt(first)!=s.charAt(last))
			return false;

		return reverseString(s,first+1,last-1);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(checkPalindrome("ABCDCBA"));
	}

}
