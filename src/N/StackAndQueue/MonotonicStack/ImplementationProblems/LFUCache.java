package N.StackAndQueue.MonotonicStack.ImplementationProblems;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
	
	class Node{
		int key;
		int value;
		int cnt;
		Node prev;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			cnt = 1;
		}
	}
	
	class List{
		Node head;
		Node tail;
		int size;
		
		List(){
			head = new Node(0,0);
			tail = new Node(0,0);
			head.next = tail;
			tail.prev = head;
			size = 0;
		}
		
		public void addFront(Node node) {
			Node temp = head.next;
			node.next = temp;
			node.prev = head;
			head.next = node;
			temp.prev = node;
			size++;
		}
		
		public void removeNode(Node node) {
			Node prevNode = node.prev;
			Node nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			size--;
		}
	}
	

	private int capacity;
	private int minFreq;
	private int curSize;
	private Map<Integer,Node> keyNode;
	private Map<Integer,List> freqListMap;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		minFreq = 0;
		curSize = 0;
		keyNode = new HashMap<>();
		freqListMap = new HashMap<>();
	}
	
	public void updateFreqListMap(Node node) {
		keyNode.remove(node.key);
		
		freqListMap.get(node.cnt).removeNode(node);
		
		if(node.cnt==minFreq && freqListMap.get(node.cnt).size==0) {
			minFreq++;
		}
		
		List nextHigherFreqList = new List();
		
		if(freqListMap.containsKey(node.cnt+1)) {
			nextHigherFreqList = freqListMap.get(node.cnt+1);
		}
		
		node.cnt+=1;
		nextHigherFreqList.addFront(node);
		freqListMap.put(node.cnt, nextHigherFreqList);
		keyNode.put(node.key, node);
	}
	
	public int get(int key) {
		if(keyNode.containsKey(key)) {
			Node node = keyNode.get(key);			
			updateFreqListMap(node);
			return node.value;
		}
		return -1;
	}
	
	public void put(int key, int value) {
		if(capacity==0) return;
		
		if(keyNode.containsKey(key)) {
			Node node = keyNode.get(key);
			node.value = value;
			updateFreqListMap(node);
		}else {
			if(curSize == capacity) {
				List list = freqListMap.get(minFreq);
				keyNode.remove(list.tail.prev.key);
				
				freqListMap.get(minFreq).removeNode(list.tail.prev);
				curSize--;
			}
			
			curSize++;
			
			minFreq = 1;
			List listFreq = new List();
			
			if(freqListMap.containsKey(minFreq)) {
				listFreq = freqListMap.get(minFreq);
			}
			
			Node newNode = new Node(key, value);
			listFreq.addFront(newNode);
			keyNode.put(key, newNode);
			freqListMap.put(minFreq, listFreq);
			
		}
		
	}
	
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}
