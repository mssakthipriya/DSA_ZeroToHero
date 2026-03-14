package L.RecursionPattern;

public class AllSubSequence {
	public static void printAllSubsequence(String s, String ans) {
		if(s.length()==0) {
			System.out.println(ans);
			return;
		}
		//pick
		printAllSubsequence(s.substring(1), ans+s.charAt(0));
		//not pick
		printAllSubsequence(s.substring(1), ans);
		
	}
	public static void main(String[] args) {
		String s = "abc";
		printAllSubsequence(s,"");
	}

}
