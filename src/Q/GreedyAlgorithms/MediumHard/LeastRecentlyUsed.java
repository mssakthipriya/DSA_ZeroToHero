package Q.GreedyAlgorithms.MediumHard;

import java.util.HashMap;

public class LeastRecentlyUsed {
	class Node{
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node(int key,int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
		
	}
	private HashMap<Integer,Node> lookup;
	private int capacity;
	private Node head;
	private Node tail;
	public LeastRecentlyUsed(int capacity) {
		this.capacity = capacity;
		this.head = new Node(-1,-1);
		this.tail = new Node(-1,-1);
		head.next = tail;
		tail.prev = head;
		this.lookup = new HashMap<>();
	}
	
	public void addNode(Node node) {
		Node temp = head.next;
		head.next = node;
		temp.prev = node;
		node.next = temp;
		node.prev = head;
	}
	
	public void removeNode(Node node) {
		Node delPrev = node.prev;
		Node delNext = node.next;
		delPrev.next = delNext;
		delNext.prev = delPrev;
	}
	public void put(int key, int value) {
		if(lookup.containsKey(key)) {
			removeNode(lookup.get(key));
			lookup.remove(key);
		}
		if(lookup.size()==capacity) {
			lookup.remove(tail.prev.key);
			removeNode(tail.prev);
		}
		addNode(new Node(key,value));
		lookup.put(key, head.next);
	}
	
	public int get(int key) {
		if(lookup.containsKey(key)) {
			Node resNode = lookup.get(key);
			int res = lookup.get(key).value;
			removeNode(lookup.get(key));
			lookup.remove(key);
			addNode(resNode);
			lookup.put(key, head.next);
			return res;
		}

		return -1;
	}
	public static void main(String[] args) {

		LeastRecentlyUsed cache = new LeastRecentlyUsed(2);
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
