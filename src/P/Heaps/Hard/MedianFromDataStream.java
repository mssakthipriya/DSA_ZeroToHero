package P.Heaps.Hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public MedianFromDataStream() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	
	public void addNum(int n) {
		maxHeap.add(n);
		minHeap.add(maxHeap.poll());
		
		if(minHeap.size()>maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}
	
	public double findMedian() {
		
		if(maxHeap.size()==minHeap.size()) {
			return (maxHeap.peek()+minHeap.peek())/2.0;
		}else {
			return maxHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		MedianFromDataStream mf = new MedianFromDataStream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2
	}

}
