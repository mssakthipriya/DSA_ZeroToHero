package L.RecursionPattern.Combos;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public static boolean isPalindrom(String s,int first,int last) {
		while(first<=last) {
			if(s.charAt(first++)!=s.charAt(last--)) {
				return false;
			}				
		}
		return true;
	}
	public static void getPalindroms(String s, int index,List<List<String>> pal,List<String> wrd) {
		if(index==s.length()) {
			pal.add(new ArrayList<>(wrd));
			return;
		}
		for (int i = index; i < s.length(); ++i) {
		if(isPalindrom(s,index,i)) {
			wrd.add(s.substring(index,i+1));
			getPalindroms(s,i+1,pal,wrd);
			wrd.remove(wrd.size()-1);
		}
		}
		
	}
	
	public static void main(String[] args) {
		String s = "aab";
		
		List<List<String>> palindroms = new ArrayList<>();
		
		getPalindroms(s,0,palindroms,new ArrayList<>());
		
		System.out.println(palindroms);
		
	}

}
