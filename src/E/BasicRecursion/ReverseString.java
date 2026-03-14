package E.BasicRecursion;

public class ReverseString {
	public static String reverse(String s) {
		if(s.length()==0) {
			return "";
		}
		
		return s.charAt(s.length()-1)+reverse(s.substring(0, s.length()-1));
	}
	public static String reverseII(String s, String rev, int index) {
		if(index<0) {
			return rev;
		}
		
		return reverseII(s, rev+s.charAt(index), index-1);
	}
	public static void main(String[] args) {
		String s = "qwerty";
		System.out.println(reverse(s));
		System.out.println(reverseII(s,"",s.length()-1));
	}
}
