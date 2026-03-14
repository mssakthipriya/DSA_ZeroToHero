package K.DoublyLinkedList;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	
	private static class Node{
		private int data;
		private Node prev;
		private Node next;
		
		public Node(int data) {
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
		
	}
	
	public void insert(int data,int position) {
		Node newNode =new Node(data);
		if(head==null) {
			head=newNode;
			tail=newNode;
			return;
		}
		Node temp = head;
		if(position==1) {
			newNode.next=head;
			head.prev=newNode;
			head = newNode;
			return;
			
		}
		for(int i=1;i<position-1;i++) {
			temp = temp.next;
		}
		newNode.next=temp.next;
		newNode.prev=temp;
		if(temp.next!=null) {
			temp.next.prev=newNode;
		}else {
			tail=temp;
		}
		temp.next = newNode;
		
		
	}
	public void delete(int position) {
		Node temp = head;
		if(position==1) {
			head=head.next;
			temp.next=null;
			head.prev=null;
		}
		for(int i=0;i<position-1;i++) {
			temp=temp.next;
		}
		if(temp.next==null) {
			tail=temp.prev;
			temp.prev.next=null;
			temp.prev=null;
		}else {
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;
		temp.next=null;
		temp.prev=null;
		}
	}
	public void reverse() {
		if(head==null) return;
		Node current = head;		
		Node temp=null;
		Node swap=tail;
		tail=head;
		while(current!=null) {
			temp=current.prev;
			current.prev=current.next;
			current.next=temp;
			current=current.prev;
		}
		
		head=swap;

	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,8,5};
		DoublyLinkedList dll = new DoublyLinkedList();
//		dll.head = new Node(arr[0]);
//		Node temp = dll.head;
//		for(int i=1;i<arr.length;i++) {
//			Node newNode = new Node(arr[i]);
//			temp.next = newNode;
//			newNode.prev = temp;
//			dll.tail=temp;
//			temp = temp.next;
//			
//		}
//
//		dll.insert(3, 3);
//		dll.insert(6, 7);
//		dll.delete(5);
//		dll.delete(6);
//		dll.display();
//		dll.reverse();
		dll.insert(5, 1);
		dll.insert(4, 1);
		dll.insert(3, 1);
		dll.insert(2, 1);
		dll.insert(1, 1);
		dll.display();
		
	}

}
