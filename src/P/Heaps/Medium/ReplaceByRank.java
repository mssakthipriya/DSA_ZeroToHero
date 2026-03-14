package P.Heaps.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReplaceByRank {
	
	public static int[] getRank(int[] arr) {
		int[] rank = new int[arr.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Map<Integer,Integer> hashmap = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		int temp = 1;
		while(!pq.isEmpty()) {
			hashmap.put(pq.poll(), temp);
			temp++;
		}
		
		for(int i=0;i<arr.length;i++) {
			rank[i] = hashmap.get(arr[i]);
		}
		
		return rank;
	}
	public static void main(String[] args) {
		int[] arr = {20,15,26,2,98,6};
		int[] rank = getRank(arr);
		
		System.out.println(Arrays.toString(rank));
	}

}
