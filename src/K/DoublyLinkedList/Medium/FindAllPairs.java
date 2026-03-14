package K.DoublyLinkedList.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllPairs {
	public static Node convertArrToDLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			newNode.prev=temp;
			temp=temp.next;
		}
		return head;
	}
	public static void display(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"<->");
			temp=temp.next;
		}
		System.out.println();
	}
	public static Node findTail(Node head) {
		Node tail = head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		return tail;
	}
	public static List<List<Integer>> findPairs(Node head, int k) {
		List<List<Integer>> pairs = new ArrayList<>();
		if(head==null) return null;
		Node tail = findTail(head);
		Node first = head;
		Node last = tail;
		while(first.data<last.data) {
			int sum = first.data+last.data;
			if(sum==k) {
				List<Integer> temp = Arrays.asList(first.data,last.data);
				pairs.add(temp);
				last=last.prev;
				first=first.next;
			}else if(sum>k) {
				last=last.prev;
			}else {
				first=first.next;
			}
		}
		
		return pairs;		
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,9};
		Node head = convertArrToDLL(arr);
		display(head);
		int k=5;
		
		List<List<Integer>> pairs = findPairs(head,k);
		System.out.println(pairs.toString());
	}

}
