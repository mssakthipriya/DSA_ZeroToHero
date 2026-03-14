package K.LinkedList.Medium;

public class AddLL {

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
	public static Node reverse(Node head) {
		Node prev = null;
		Node temp = head;
		while(temp!=null) {
			Node front=temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;
	}
	public static Node addLL(Node head1,Node head2) {
		Node t1 = head1;
		Node t2 = head2;
		Node dummy = new Node(-1);
		Node temp=dummy;
		int carry=0;
		while(t1!=null || t2!=null || carry==1) {
			int sum = 0;
			if(t1!=null) {
				sum+=t1.data;
				t1=t1.next;
			}
			if(t2!=null) {
				sum+=t2.data;
				t2=t2.next;
			}
			sum+=carry;
			carry=sum/10;
			Node newNode = new Node(sum%10);
			temp.next = newNode;
			temp=temp.next;
		}

		
		return dummy.next;		
	}
	public static void main(String[] args) {
		int[] arr1 = {9,9,9,9,9,9,9};
		int[] arr2 = {9,9,9,9};
		
		Node head1 = convertArr2LL(arr1);
		display(head1);
		Node head2 = convertArr2LL(arr2);
		display(head2);
		Node sumHead = addLL(head1,head2);
		display(sumHead);
	}
}
