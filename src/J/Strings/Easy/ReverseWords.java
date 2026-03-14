package J.Strings.Easy;

public class ReverseWords {
	
	public static String reverseWords(String s) {
		String rev = "";
		int start = -1;
		for(int i=0;i<s.length();i++) {
            // Word ends when space or end of string is reached
            if (s.charAt(i) == ' ') {
                if (start != -1) {
                    String word = s.substring(start, i);
                    rev = word + (rev.isEmpty() ? "" : " " + rev);
                    start = -1;
                }
            } else {
                if (start == -1) {
                    start = i;  // start of a new word
                }
            }
		}
		if(start!=-1) {
			String word = s.substring(start, s.length());
			rev = word + (rev.isEmpty() ? "" : " " + rev);
		}
		
		return rev;
	}

	public static void main(String[] args) {
		//String sentence = "  hello   world  ";
		String sentence = "sky is blue";
		//String sentence = "this is an amazing program";
		String reverse = reverseWords(sentence);
		
		System.out.println("The reversed sentence is::"+reverse+"::");
	}
}
