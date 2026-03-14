package T.Graphs.BFS_DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import Z.Utilities.*;



public class WordLadder {
	public static int ladderLength(String startWord,String targetWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		Queue<Pair<String,Integer>> q = new LinkedList<>();
		
		q.add(new Pair<>(startWord,1));
		set.remove(startWord);
		
		while(!q.isEmpty()) {
			Pair<String, Integer> p = q.poll();
			String word = p.getKey();
			int step = p.getValue();
			
			if(word.equals(targetWord)) return step;
			
			char[] letters = word.toCharArray();
			for(int i=0;i<word.length();i++) {
				char original = letters[i];
				
				for(char a = 'a';a<='z';a++) {
					letters[i]=a;
					String newWord = new String(letters);
					if(set.contains(newWord)) {
						set.remove(newWord);
						q.add(new Pair<>(newWord,step+1));
					}
				}
				
				letters[i] = original;
				
			}
		}
		
		return 0;
	}
	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("des","der","dfr","dgt","dfs");
		String startWord = "der", targetWord = "dfs";
		
		int ans = ladderLength(startWord,targetWord,wordList);
		
		System.out.println(ans);
	}

}
