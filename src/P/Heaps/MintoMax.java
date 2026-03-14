package P.Heaps;

import java.util.Arrays;

public class MintoMax {
	public static void maxHeapify(int[] min, int i,int n) {
		int left = i*2+1;
		int right = i*2+2;
		
		int largest = i;
		if(left<n && min[left]>min[largest]) largest=left;
		if(right<n && min[right]>min[largest]) largest=right;
		if(largest!=i) {
			int temp = min[largest];
			min[largest] = min[i];
			min[i] = temp;
			maxHeapify(min,largest,n);
		}
	}
	public static void getMaxHeap(int[] min) {
		int n = min.length;
		for(int i=(n-2)/2;i>=0;--i){
			maxHeapify(min,i,n);
		}
	}
	
	
	public static void main(String[] args) {
		//min heap
		int minHeap[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
		
		getMaxHeap(minHeap);
		
		System.out.println("Max Heap:"+Arrays.toString(minHeap));
		
	}

}
