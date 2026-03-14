package P.Heaps;

import java.util.ArrayList;

public class MaxHeap {

	private ArrayList<Integer> heap;
	
	public MaxHeap() {
		heap = new ArrayList<>();
	}
	
	public int parent(int i) {
		return (i-1)/2;
	}
	
	public int leftChild(int i) {
		return 2*i+1;
	}
	
	public int rightChild(int i) {
		return 2*i+2;
	}
	
	public void swap(int i,int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	public void insert(int value) {
		heap.add(value);
		int currIndex = heap.size()-1;
		while(currIndex>0 && heap.get(parent(currIndex))<heap.get(currIndex)) {
			swap(currIndex,parent(currIndex));
			currIndex = parent(currIndex);
		}
	}
	
	public int extractMax() {
		if(heap.isEmpty()) {
			throw new RuntimeException("The heap is empty");
		}
		int max = heap.get(0);
		int last = heap.remove(heap.size()-1);
		
		if(!heap.isEmpty()) {
			heap.set(0, last);			
			int currIndex=0;
			
			while(true) {
				int left = leftChild(currIndex);
				int right = rightChild(currIndex);
				
				int largest = currIndex;
				if(left<heap.size() && heap.get(largest)<heap.get(left)) {
					largest = left;
				}
				if(right<heap.size() && heap.get(largest)<heap.get(right)) {
					largest = right;
				}
				
				if(largest == currIndex) {
					//heap is restored
					break;
				}
				
				swap(currIndex,largest);
				currIndex = largest;
				
			}
		}
		return max;
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();

        // Insert values into the max heap
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(25);

        // Extract and print the maximum values from the heap
        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Extracted Max: " + maxHeap.extractMax());
	}
}
