package U.DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
	
    public static int longestStrChain(String[] words) {
        int n = words.length;
    	Arrays.sort(words, Comparator.comparingInt(String::length));
    	int[] dp = new int[n];
    	
    	Arrays.fill(dp, 1);
    	
    	int maxLength = 0;
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(checkPossiblePredecessor(words[i], words[j]) && dp[i]<dp[j]+1) {
    				dp[i]=dp[j]+1;
    			}
    		}
    		if(maxLength<dp[i]) {
    			maxLength = dp[i];
    		}
    	}
    	
    	return maxLength;
    }
    
    public static boolean checkPossiblePredecessor(String s1, String s2) {
    	
    	if(s1.length()!=s2.length()+1) return false;
    	
    	int i=0,j=0;
    	while(i<s1.length()) {
    		if(j<s2.length()&& s1.charAt(i)==s2.charAt(j)) {
    			i++;
    			j++;
    		}else {
    			i++;
    		}
    	}
    	
    	if(i==s1.length() && j==s2.length()) return true;
    	
    	return false;
    } 
	
	public static void main(String[] args) {
		String[] words = {"a","b","ba","bca","bda","bdca"};
		
		int maxLength = longestStrChain(words);
		
		System.out.println(maxLength);
		
	}

}
