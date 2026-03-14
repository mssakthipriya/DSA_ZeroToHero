package V.Tries;


public class Trie {
	private TrieNode root;
	
	class TrieNode{
		private TrieNode[] children;
		private boolean flag;
	
		public TrieNode() {
			children = new TrieNode[26];
			flag = false;
		}
		
		public boolean containsKey(char ch) {
			return (children[ch-'a']!=null);
		}
		
		public void put(char ch,TrieNode node) {
			children[ch-'a'] = node;
		}
		
		public TrieNode get(char ch) {
			return children[ch-'a'];
		}
		
		public void setEnd() {
			flag = true;
		}
		
		public boolean isEnd() {
			return flag;
		}
	
		public int getIndex(char letter) {
			return letter-'a';
		}
	}
	
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		
		for(int i=0;i<word.length();i++) {
			if(!current.containsKey(word.charAt(i))) {
				current.put(word.charAt(i), new TrieNode());
			}
			
			current = current.get(word.charAt(i));
		}
		
		current.setEnd();
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		
		for(int i=0;i<word.length();i++) {
			if(!current.containsKey(word.charAt(i))) {
				return false;
			}
			current = current.get(word.charAt(i));
		}
		return current.isEnd();
	}
	
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		
		for(int i=0;i<prefix.length();i++) {
			if(!current.containsKey(prefix.charAt(i))) {
				return false;
			}
			current = current.get(prefix.charAt(i));
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
	}

}

