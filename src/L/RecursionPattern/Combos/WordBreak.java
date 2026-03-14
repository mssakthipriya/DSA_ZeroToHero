package L.RecursionPattern.Combos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static boolean foundWord(String word, List<String> dict) {
		int n = word.length();
		Set<String> w = new HashSet<>(dict);
		
		int maxLen = 0;
		
		for(String s :dict) {
			maxLen = Math.max(maxLen,s.length());
		}
		
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		
		for(int i=1;i<=n;i++) {
			for(int j=i-1;j>=Math.max(0, i-maxLen);j--) {
				System.out.println("i:"+i+", j:"+j+", dp[j]:"+dp[j]+", substring:"+word.substring(j, i));
				if(dp[j] && w.contains(word.substring(j, i))) {
					System.out.println("hi");
					dp[i]=true;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		return dp[n];
	}
	public static void main(String[] args) {
		String word = "infrontof";		
		
		List<String> dict = Arrays.asList("front","in","out","of");
		
		boolean ans = foundWord(word,dict);
		
		System.out.println("Is the word fragments found in dictinary:"+ans);
		
	}



}
