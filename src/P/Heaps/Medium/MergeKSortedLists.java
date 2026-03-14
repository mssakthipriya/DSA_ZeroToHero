package P.Heaps.Medium;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
public class MergeKSortedLists {
	
	public static Node convertArrToLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		return head;
	}
	public static void printLL(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
    public static Node mergeKLists(Node[] lists) {
        Node dummy = new Node(-1);
        
        PriorityQueue<Map.Entry<Integer,Node>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        for(Node node:lists) {
        	if(node!=null) {
        		pq.add(new AbstractMap.SimpleEntry<>(node.data,node));
        	}
        }
        
        Node temp = dummy;
        
        while(!pq.isEmpty()) {
        	Map.Entry<Integer,Node> entry = pq.poll();
        	
        	if(entry.getValue().next!=null) {
        		pq.add(new AbstractMap.SimpleEntry<>(entry.getValue().next.data,entry.getValue().next));
        	}
        	temp.next = entry.getValue();
        	temp=temp.next;
        }
        
        return dummy.next;
    }
	public static void main(String[] args) {
		int[][] initList = {{1,4,5},{1,3,4},{2,6}};
		Node[] list = new Node[initList.length];
		for(int i=0;i<initList.length;i++) {
			Node head = convertArrToLL(initList[i]);
			list[i] = head;
		}
		
		Node head = mergeKLists(list);
		printLL(head);
	}

}
