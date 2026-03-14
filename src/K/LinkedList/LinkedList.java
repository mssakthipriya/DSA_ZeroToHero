package K.LinkedList;

public class LinkedList {
	private Node head;
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void display() {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		while(!(temp.next==null)) {
			temp = temp.next;
		}
		temp.next=newNode;
	}
	public void insertInBetween(int data, int position) {
		Node newNode = new Node(data);
		int count=1;
		Node temp = head;
		while(count<position-1) {
			temp=temp.next;
			count++;
		}
		newNode.next = temp.next;
		temp.next=newNode;
	}
	public void delete(int position) {
		int count=1;
		Node temp = head;
		if(position==1) {
			head =head.next;
			temp.next = null;
		}
		while(count<position-1) {
			temp = temp.next;
			count++;
		}
		if(temp.next.next == null) {
			temp.next=null;
		}else {
			Node temp2 = temp.next;
			temp.next = temp.next.next;
			temp2.next = null;
		}
		
	}
	public int getLength() {
		if(head==null) return 0;
		int count=1;
		Node temp=head;
		while(temp.next!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int search(int data) {
		int index = -1;
		int count=0;
		Node temp = head;
		while(temp!=null) {
			if(temp.data==data){
				count++;
				index=count;
				break;
			}else {
				count++;
				temp=temp.next;
			}
		}

		
		return index;
	}

	public static void main(String[] args) {
		int[] arr = {2,5,8,7};
		LinkedList ll = new LinkedList();
		ll.head = new Node(arr[0]);
		Node temp = ll.head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = newNode;
			
		}		
		
		ll.insertAtHead(1);
		ll.insertAtEnd(9);
		ll.insertInBetween(3,3);
		ll.insertInBetween(4,4);
		ll.delete(6);
		ll.delete(7);
		ll.display();
		System.out.println("The length of the linked list is:"+ll.getLength());
		System.out.println("The number is found in the position:"+ll.search(7));

	}
}
