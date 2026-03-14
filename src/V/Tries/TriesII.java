package V.Tries;

public class TriesII {
	private TrieNode root;
	
	class TrieNode{
		private TrieNode[] children;
		private boolean isWord;
		private int cntEndWtih;
		private int cntPrefix;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
			this.cntEndWtih = 0;
			this.cntPrefix = 0;
		}
		// check if a specific letter is present
		public boolean containsKey(char x) {
			
			return children[x-'a']!=null;
		}
		//return a specific node
		public TrieNode getNode(char x) {
			
			return children[x-'a'];
		}
		
		public void put(char x, TrieNode node) {
			children[x-'a'] = node;
		}
		
		public void incrementCount() {
			cntEndWtih++;
		}
		
		public void incrementPrefix() {
			cntPrefix++;
		}
		
		public void removeEnd() {
			cntEndWtih--;
		}
		
		public void removePrefix() {
			cntPrefix--;
		}
		
		public int getEnd() {
			return cntEndWtih;
		}
		
		public int getPrefix() {
			return cntPrefix;
		}
		
		public void setEnd() {
			isWord = true;
		}
	}
	
	public TriesII() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new TrieNode());
			}
			
			node = node.getNode(word.charAt(i));
			node.incrementPrefix();
		}
		
		node.incrementCount();
		node.setEnd();
		
	}
	
	public int countWordsEqualTo(String word) {
		TrieNode node = root;
		
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.getNode(word.charAt(i));
			}else {
				return 0;
			}
		}
		
		
		return node.getEnd();
	}
	
	public int countWordsStartingWith(String word) {
		TrieNode node = root;
		
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				node = node.getNode(word.charAt(i));
			}else {
				return 0;
			}
		}
		
		
		return node.getPrefix();
	}
	
	 public void erase(String word) {
		 TrieNode node = root;
		 
		 for(int i=0;i<word.length();i++) {
			 if(node.containsKey(word.charAt(i))) {
				 node = node.getNode(word.charAt(i));
				 node.removePrefix();
			 }else {
				 return;
			 }
		 }
		 
		 node.removeEnd();
	 }
	
	public static void main(String[] args) {
		TriesII trie = new TriesII();
        trie.insert("apple");
        trie.insert("apple");
        System.out.println("Inserting strings 'apple' twice into Trie");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
	}

}
