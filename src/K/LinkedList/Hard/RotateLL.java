package K.LinkedList.Hard;

public class RotateLL {

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
	
	public static void display(Node head) {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	
	public static Node rotate(Node head, int k) {
		
		if(head==null ||head.next==null||k==0) return head;
		
		Node temp = head;
		int length = 1;
		while(temp.next!=null) {
			++length;
			temp=temp.next;
		}
		
		temp.next=head;
		k=k%length;
		int part = length-k;
		
		for(int i=0;i<part;i++) {
			temp=temp.next;
		}
		head=temp.next;
		temp.next = null;
				
		return head;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k=2;
		Node head = convertArr2LL(arr);
		display(head);
		Node newHead = rotate(head, k);
		display(newHead);
		
	}
}
