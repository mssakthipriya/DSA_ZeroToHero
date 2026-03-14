package P.Heaps.Hard;

import java.util.PriorityQueue;

public class ConnectNRopes {
	
	public static int getMinCost(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cost = 0;
		
		for(int i=0;i<arr.length;i++) {
			pq.add(arr[i]);
		}
		
		while(pq.size()>1) {			
			int a = pq.poll();
			int b = pq.poll();
			int sum = a+b;
			cost+=sum;
			pq.add(sum);
			
		}
		
		
		return cost;
	}
	
	public static void main(String[] args) {
		int[] n = {4,3,2,6};
		
		int min = getMinCost(n);
		System.out.println(min);
	}

}
