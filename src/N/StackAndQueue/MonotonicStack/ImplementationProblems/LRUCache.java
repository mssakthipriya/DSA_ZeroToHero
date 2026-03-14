package N.StackAndQueue.MonotonicStack.ImplementationProblems;

import java.util.HashMap;

public class LRUCache {
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		Node(int key, int value){
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
	}
	Node head;
	Node tail;
	int capacity;
	HashMap<Integer,Node> hmap = new HashMap<>();
	public LRUCache(int capacity){
		this.capacity = capacity;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	public void remove(Node node) {
		Node left = node.prev;
		Node right = node.next;
		left.next = right;
		right.prev = left;		
	}
	
	public void addNode(Node node) {
		Node temp = head.next;
		node.next = temp;
		node.prev = head;
		head.next = node;
		temp.prev = node;
	}
	
	public int get(int key) {
		if(hmap.containsKey(key)) {
			Node temp = hmap.get(key);
			int res = temp.value;
			hmap.remove(key);
			remove(temp);
			addNode(temp);
			hmap.put(key, head.next);
			return res;
		}
		
		return -1;
	}
	
	public void put(int key,int value) {
		Node newNode = new Node(key, value);
		
		if(hmap.containsKey(key)) {
			Node delNode = hmap.get(key);
			hmap.remove(key);
			remove(delNode);			
		}
		
		if(hmap.size()==capacity) {
			hmap.remove(tail.prev.key);
			remove(tail.prev);
		}
		
		addNode(newNode);
		hmap.put(key, head.next);
	}
	

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
