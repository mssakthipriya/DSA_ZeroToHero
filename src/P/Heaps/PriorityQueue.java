package P.Heaps;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
	ArrayList<T> priorityQ;
	
	
	PriorityQueue(){
		priorityQ = new ArrayList<>();
	}
	
	public void enqueue(T item) {
		
		priorityQ.add(item);
		int currIndex = priorityQ.size()-1;
		
		while(currIndex>0) {
			int parentIndex = (currIndex-1)/2;
			
			if(priorityQ.get(currIndex).compareTo(priorityQ.get(parentIndex))<=0) {
				break;
			}
			
			T temp = priorityQ.get(currIndex);
			priorityQ.set(currIndex, priorityQ.get(parentIndex));
			priorityQ.set(parentIndex, temp);
			currIndex = parentIndex;
		}
	}
	public T dequeue() {
		int lastIndex = priorityQ.size()-1;
		T firstItem = priorityQ.get(0);
		priorityQ.set(0, priorityQ.get(lastIndex));
		priorityQ.remove(lastIndex);
		
		lastIndex--;
		
		int parentIndex = 0;
		
		while(true) {
			int leftChild = parentIndex*2+1;
			int rightChild = leftChild+1;
			
			int largest = parentIndex;
			if(leftChild<=lastIndex && priorityQ.get(leftChild).compareTo(priorityQ.get(largest))>0) {
				largest = leftChild;
			}
			if(rightChild<=lastIndex && priorityQ.get(rightChild).compareTo(priorityQ.get(largest))>0) {
				largest = rightChild;
			}
			if(largest==parentIndex) break;
			
			T temp = priorityQ.get(parentIndex);
			priorityQ.set(parentIndex, priorityQ.get(largest));
			priorityQ.set(largest, temp);
			parentIndex = largest;
			
		}
		
		return firstItem;
	}
	
	public T peek() {
		return priorityQ.get(0);
	}
	
	public int count() {
		return priorityQ.size();
	}
	
	public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("Size" + "  " + "Peek");
        pq.enqueue(1);
        System.out.println(pq.count() + "     " + pq.peek());
        pq.enqueue(10);
        pq.enqueue(-8);
        System.out.println(pq.count() + "     " + pq.peek());
        pq.dequeue();
        System.out.println(pq.count() + "     " + pq.peek());
        pq.dequeue();
        System.out.println(pq.count() + "     " + pq.peek());
        pq.enqueue(25);
        System.out.println(pq.count() + "     " + pq.peek());
	}

}
