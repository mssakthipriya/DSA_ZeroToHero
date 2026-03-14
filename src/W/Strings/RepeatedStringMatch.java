package W.Strings;

public class RepeatedStringMatch {
	private static final int BASE = 113;
	private static final int MOD = 1_000_000_007;
	
	public static long rollHash(long textHash, char start, char end, long power) {
        textHash = textHash - (start * power) % MOD;
        if (textHash < 0)
        	textHash += MOD;
        textHash = (textHash * BASE + end) % MOD;
        return textHash;
	}
	public static long getHighestPower(int length) {
		long pow = 1;
		for(int i=1;i<length;i++) {
			pow=(pow*BASE)%MOD;
		}
		return pow;
	}
	public static long getHash(String s) {
		long hash = 0;
		for(int i=0;i<s.length();i++) {
			hash = (hash*BASE+s.charAt(i))%MOD;
		}
		
		return hash;
	}
	public static boolean isSubByRabinKarp(String text, String pattern) {
		int textLength = text.length();
		int patternLength = pattern.length();
		
		long textHash = getHash(text.substring(0, patternLength));
		long patternHash = getHash(pattern);
		long power = getHighestPower(patternLength);
			
		for(int i=0;i<=textLength-patternLength;i++) {
			if(textHash==patternHash) {
				if(text.substring(i, i+patternLength).equals(pattern)) {
					return true;
				}
			}
			
			//continue rolling
			if(i<textLength-patternLength) {
				textHash = rollHash(textHash,text.charAt(i),text.charAt(i+patternLength),power);
			}
		}
		
		return false;
	}
	
	public static int getRepeatations(String text, String pattern) {
		// Minimum repeats needed to cover length of b
		int minReps =(text.length()+pattern.length()-1)/text.length();
		
		// Build the repeated string
		StringBuilder repText = new StringBuilder();
		for(int i=0;i<minReps;i++) {
			repText.append(text);
		}
		// Check if b is a substring of repeated a (minRepeats times)
		if(isSubByRabinKarp(repText.toString(),pattern)) {
			return minReps;
		}
		 // Check with one more repeat to account for overlap
		repText.append(text);
		if(isSubByRabinKarp(repText.toString(),pattern)) {
			return minReps+1;
		}
		
		
		return -1;
	}
	public static void main(String[] args) {
		String a = "abcd";
		//String b = "abcd";
		String b = "cdabcdab";
		
		int n = getRepeatations(a,b);
		
		System.out.println("The string should be repeated "+n+" times in order to get: "+a);
	}
}
