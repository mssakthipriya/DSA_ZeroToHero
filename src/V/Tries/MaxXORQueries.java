package V.Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxXORQueries {
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
	
	public MaxXORQueries() {
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
	
	public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(nums);
        List<int[]> offlineQueries = new ArrayList<>();
        int index=0;
        for(int[] query : queries) {
        	offlineQueries.add(new int[] {query[1],query[0],index++});
        }
        
        offlineQueries.sort(Comparator.comparingInt(a->a[0]));
        
        int i = 0, n = nums.length;
        for(int[] query : offlineQueries) {
        	
        	while(i<n && nums[i]<=query[0]) {
        		insert(nums[i]);
        		i++;
        	}
        	
        	if(i!=0) {
        		result[query[2]] = getMaxXOR(query[1]);
        	}else {
        		result[query[2]] = -1;
        	}
        }
        
        return result;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {5,2,4,6,6,3};
		int[][] queries = {{12,4},{8,1},{6,3}};
		
		MaxXORQueries maxQ = new MaxXORQueries();
		
		int[] result = maxQ.maximizeXor(nums,queries);
		
		System.out.println(Arrays.toString(result));

	}

}
