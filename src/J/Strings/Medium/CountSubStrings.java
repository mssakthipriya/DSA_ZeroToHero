package J.Strings.Medium;

public class CountSubStrings {
	public static int countNonEmptySub(String s) {
		int n = s.length();
		int count = n*((n+1)/2);
		
		return count;
	}
	public static void main(String[] args) {
		String s= "abc";
		
		System.out.println("The number of non empty substrings of the string "+s+" is:"+countNonEmptySub(s));
				
	}

}
