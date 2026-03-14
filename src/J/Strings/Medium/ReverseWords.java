package J.Strings.Medium;

public class ReverseWords {
	
	public static String reverseWords(String s) {
		String rev = "";
		int j = 0;
		String[] str = s.trim().split("\\s+");
        for(int i=str.length-1; i>=0;i--) {
        	rev+=str[i];
        	if(i!=0) {
        		rev+=" ";
        	}
        }
		return rev;
	}

	public static void main(String[] args) {
		String sentence = "sky is the limit";
		String reverse = reverseWords(sentence);
		
		System.out.println("The reversed sentence is::"+reverse+"::");

	}
}
