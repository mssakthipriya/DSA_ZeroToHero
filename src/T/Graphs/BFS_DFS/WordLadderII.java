package T.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	Set<String> wordSet = new HashSet<>(wordList);
    	List<List<String>> ans = new ArrayList<>();
    	Queue<List<String>> q = new LinkedList<>();
    	
    	q.add(new ArrayList<>(Arrays.asList(beginWord))); 
    	List<String> usedWords = new ArrayList<>();
    	usedWords.add(beginWord);
    	int level = 0;
    	
    	while(!q.isEmpty()) {
    		List<String> initList = q.poll();
    		
    		if(initList.size()>level) {
    			level++;
    			for(String s : usedWords) {
    				wordSet.remove(s);
    			}
    		}
    		
    		String word = initList.get(initList.size()-1);
    		
    		if(word.equals(endWord)) {
    			if(ans.isEmpty()) {
    				ans.add(new ArrayList<>(initList));
    			}else if(initList.size()==ans.get(0).size()) {
    				ans.add(new ArrayList<>(initList));
    			}
    		}
    		
    		char[] wordArr = word.toCharArray();
    		
    		for(int i=0;i<wordArr.length;i++) {
    			char original = wordArr[i];
    			
    			for(char c = 'a';c<='z';c++) {
    				wordArr[i] = c;
    				String newWord = new String(wordArr);
    				
    				if(wordSet.contains(newWord)) {
    					initList.add(newWord);
    					q.add(new ArrayList<>(initList));
    					usedWords.add(newWord);
    					initList.remove(initList.size()-1);
    				}
    			}
				wordArr[i] = original;
    		}
    		
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		
		List<List<String>> ans = findLadders(beginWord, endWord, wordList);

		for(List<String> s : ans) {
			System.out.println(s.toString());
		}
	}

}
