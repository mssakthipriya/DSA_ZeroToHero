package K.LinkedList.Medium;

public class ReverseLinkedList {
	public static Node convertArrToLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp=head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}		
		
		return head;
	}
	public static void display(Node head) {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	public static Node reverse(Node head) {
		Node temp = head;
		Node prev = null;
		while(temp!=null) {
			Node front = temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = convertArrToLL(arr);
		display(head);
		head = reverse(head);
		display(head);
		
	}

}
