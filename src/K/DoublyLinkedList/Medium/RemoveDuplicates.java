package K.DoublyLinkedList.Medium;


class Node{
	int data;
	Node next;
	Node prev;
	
	public Node(int data) {
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}
public class RemoveDuplicates {

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
	public static Node removeDupes(Node head) {
		if(head == null) return null;
		
		Node temp=head;
		
		while(temp!=null && temp.next!=null) {
			if(temp.data==temp.next.data) {
				Node t1=temp.next.next;
				temp.next = t1;
				if(t1!=null)
					t1.prev=temp;
			}else {
				temp=temp.next;
			}
		}
		
		return head;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,2,2,3,3};
		Node head = convertArrToDLL(arr);
		display(head);
		Node newHead = removeDupes(head);
		display(newHead);
	}
}
