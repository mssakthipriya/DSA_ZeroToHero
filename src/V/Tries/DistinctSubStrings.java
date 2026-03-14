package V.Tries;

import V.Tries.TriesII.TrieNode;

public class DistinctSubStrings {
	TrieNode root;
	class TrieNode{
		private TrieNode[] children;
		private boolean isWord;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
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
		public void setEnd() {
			isWord = true;
		}
				
	}
	
	public DistinctSubStrings() {
		this.root = new TrieNode();
	}
	
	public int countDistinctSubs(String str) {
		int count = 0;
		int n = str.length();
		
		
		for(int i=0;i<n;i++) {
			TrieNode node = root;
			for(int j=i;j<n;j++) {
				if(!node.containsKey(str.charAt(j))) {
					node.put(str.charAt(j), new TrieNode());
					count++;
				}
				
				node = node.getNode(str.charAt(j));
			}
		}
		
		
		
		
		return count+1;
	}
	
	public static void main(String[] args) {
		String s = "abab";
		
		DistinctSubStrings ds = new DistinctSubStrings();
		System.out.println(ds.countDistinctSubs(s));
	}

}
