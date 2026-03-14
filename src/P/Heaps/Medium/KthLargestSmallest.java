package P.Heaps.Medium;

import java.util.PriorityQueue;

public class KthLargestSmallest {
	
	public static int kthLargestMaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->(b-a));
		for(int i=0;i<arr.length;i++) {
			maxHeap.add(arr[i]);
		}
		for(int i=0;i<k-1;i++) {
			maxHeap.poll();
		}
		
		return maxHeap.peek();
	}
	
	public static int kthSmallestMinHeap(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i=0;i<arr.length;i++) {
			minHeap.add(arr[i]);
		}
		for(int i=0;i<k-1;i++) {
			minHeap.poll();
		}
		return minHeap.peek();
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 6, 4, 5, 3};
		int k=3;
		int max = kthLargestMaxHeap(arr,k);
		
		int min = kthSmallestMinHeap(arr,k);
		
		System.out.println("The "+k+"th largest element is:"+max+", and the "+k+"th smallest element is:"+min);
	}

}
