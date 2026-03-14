package K.LinkedList.Medium;

public class RemoveNthFromLast {

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
	public static void display(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void removeLastNth(Node head, int n) {
		//Node dummy = new Node(-1);
		//dummy.next=head;
		Node fast = head;
		Node slow=head;
		for(int i=0;i<n;i++) {
			fast=fast.next;
			if(fast==null)
				return;

		}
		while(fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		Node delNode = slow.next;
		slow.next = slow.next.next;
		delNode.next=null;
		
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int n=3;
		Node head = convertArrToLL(arr);
		display(head);
		removeLastNth(head,n);
		display(head);
	}
}
