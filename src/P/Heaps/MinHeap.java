package P.Heaps;

import java.util.ArrayList;

public class MinHeap {
	private ArrayList<Integer> heap;
	
	public MinHeap() {
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
		while(currIndex>0 && heap.get(currIndex)< heap.get(parent(currIndex))) {
			swap(currIndex,parent(currIndex));
			currIndex = parent(currIndex);
		}
	}
	
	public int extractMin() {
		if(heap.isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		
		int min = heap.get(0);
		
		int last = heap.remove(heap.size()-1);
		
		if(!heap.isEmpty()) {
			heap.set(0, last);
			int currIndex = 0;
			
			while(true) {
				int left = leftChild(currIndex);
				int right = rightChild(currIndex);
				
				int smallest = currIndex;
				if(left<heap.size() && heap.get(left)<heap.get(smallest)) {
					smallest=left;
				}
				
				if(right<heap.size() && heap.get(right)<heap.get(smallest)) {
					smallest=right;
				}
				
				if(smallest==currIndex) {
					//heap property restored
					break;
				}
				swap(currIndex,smallest);
				currIndex = smallest;
			}
		}
		
		return min;
	}
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(25);
        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Extracted Min: " + minHeap.extractMin());
	}
}
