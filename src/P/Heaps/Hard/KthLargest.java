package P.Heaps.Hard;

import java.util.PriorityQueue;


public class KthLargest {
	PriorityQueue<Integer> pq;
	int k;
	public KthLargest(int k,int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>();
		for(int i=0;i<nums.length;i++) {
			add(nums[i]);
		}		
	}
	
	public int add(int val) {
		
		if(pq.size()<k||pq.peek()<val) {
			pq.add(val);
			if(pq.size()>k) {
				pq.remove();
			}
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}

}
