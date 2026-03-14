package K.LinkedList.Medium;



public class EvenOdd {
	public static Node convertArr2LL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp=head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
		
		return head;
	}
	
	public static Node rearrange(Node head) {
		Node odd = head;
		Node even = head.next;
		Node evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next=odd.next.next;
			odd = odd.next;
			
			even.next = even.next.next;
			even=even.next;
		}
		odd.next=evenHead;
		
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
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = convertArr2LL(arr);
		Node oddeven = rearrange(head);
		display(oddeven);
	}

}
