package V.Tries;

public class MaxXORTwoNums {
	private TrieNode root;
	
	class TrieNode{
		private TrieNode[] children;
		private boolean flag;
		
		public TrieNode() {
			this.children = new TrieNode[2];
			this.flag = false;
		}
		
		public boolean containsKey(int bit) {
			return children[bit]!=null;
		}
		
		public TrieNode get(int bit) {
			return children[bit];
		}
		
		public void put(int bit, TrieNode node) {
			children[bit] = node;
		}
		
	}
	
	public MaxXORTwoNums() {
		this.root = new TrieNode();
	}
	
	public void insert(int num) {
		TrieNode node  = root;
		
		for(int i=31;i>=0;i--) {
			int bit = (num>>i)&1;
			
			if(!node.containsKey(bit)) {
				node.put(bit, new TrieNode());
			}
			node = node.get(bit);
		}
	}
	
	public int getMaxXOR(int num) {
		TrieNode node = root;
		int maxXOR = 0 ;
		for(int i=31;i>=0;i--) {
			int bit = (num>>i)&1;
			if(node.containsKey(1-bit)) {
				maxXOR |=(1<<i);
				node = node.get(1-bit);
			}else {
				node = node.get(bit);
			}
		}
		
		return maxXOR;
	}
	
	public int findMaximumXOR(int[] nums) {
		int maxXOR = 0;
		
		for(int num:nums) {
			insert(num);
		}
		
		for(int i=0;i<nums.length;i++) {
			maxXOR = Math.max(maxXOR, getMaxXOR(nums[i]));
		}
		
		return maxXOR;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {26, 49, 30, 15, 69};
		MaxXORTwoNums sol = new MaxXORTwoNums();
        System.out.println(sol.findMaximumXOR(nums));
	}

}
