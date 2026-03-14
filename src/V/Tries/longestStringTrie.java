package V.Tries;

public class longestStringTrie {
	TrieNode root;
	
	class TrieNode{
		private TrieNode[] children;
		private boolean isWord;
		private int cntEnd;
		private int cntPrefix;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
			this.cntEnd = 0;
			this.cntPrefix = 0;
		}
		
		public boolean containsKey(char x) {
			return children[x-'a']!=null;
		}
		
		public TrieNode getNode(char x) {
			return children[x-'a'];
		}
		
		public void put(char x, TrieNode node) {
			children[x-'a'] = node;
		}
		
		public void increaseEnd() {
			cntEnd++;
		}
		
		public void increasePrefix() {
			cntPrefix++;
		}
		
		public void removeEnd() {
			cntEnd--;
		}
		
		public void removePrefix() {
			cntPrefix--;
		}
		
		public int getEnd() {
			return cntEnd;
		}
		
		public int getPrefix() {
			return cntPrefix;
		}
		
		public void setEnd() {
			isWord = true;
		}
	}
	
	public longestStringTrie() {
		this.root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new TrieNode());
			}			
			node = node.getNode(word.charAt(i));
			node.increasePrefix();
		}
		
		node.increaseEnd();
		node.setEnd();
	}
	
	public boolean allPrefixExist(String word) {
		
		TrieNode node = root;
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.getNode(word.charAt(i));
			if(!node.isWord) return false;
		}
		
		return true;
	}
	
	public String getLongestPrefixString(String[] arr) {
		String result = "";
		
		for(int i=0;i<arr.length;i++) {
			insert(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			if(allPrefixExist(arr[i])) {
				if(arr[i].length()>result.length()) {
					result = arr[i];
				}else if(arr[i].length()==result.length() && arr[i].compareTo(result)<0) {
					result = arr[i];
				}
			}
		}
		
		if(result.equals("")) return "none";
		return result;
	}
	
	public static void main(String[] args) {
		
		longestStringTrie trie = new longestStringTrie();
		String[] arr = {"ab", "a", "abc", "abd"};
        System.out.println(trie.getLongestPrefixString(arr));
	}

}
