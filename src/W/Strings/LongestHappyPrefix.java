package W.Strings;

public class LongestHappyPrefix {
	
    public static String longestPrefix(String s) {
        int[] dp = new int[s.length()];
        int index = 0;
        
        for(int i=1;i<s.length();i++) {
        	while(index>0 && s.charAt(index)!=s.charAt(i)) {
        		index = dp[index-1];
        	}
        	if(s.charAt(index)==s.charAt(i)) {
        		index++;
        	}
        	dp[i] = index;
        }
        return s.substring(0,dp[dp.length - 1]);
    }
    
	public static void main(String[] args) {
		String s = "ababab";
		
		String ans = longestPrefix(s);
		
		System.out.println(ans);
	}
}
