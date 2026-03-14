package K.LinkedList.Medium;

public class AddOneToLL {

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
			Node front = temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
			
		}
		return prev;
	}
	public static Node addOne(Node head) {
		
		Node revHead = reverse(head);
		Node temp=revHead;

		int carry=1;
		while(temp!=null) {
			int sum = carry +temp.data;
			if(sum<10) {
				temp.data=sum;
				carry=0;
				break;
			}else {
				temp.data=0;
				carry=1;
			}
			temp=temp.next;
		}
		head = reverse(revHead);
		if(carry==1) {
			Node newNode = new Node(1);
			newNode.next = head;
			return newNode;
		}
		
		return head;
	}
	public static int addHelper(Node temp) {
		if(temp==null) return 1;
		
		int carry=addHelper(temp.next);
		int sum=temp.data+carry;
		if(sum<10) {
			temp.data = sum;
			return 0;
		}
		temp.data=0;		
		return 1;
	}
	public static Node addOneII(Node head) {

		int carry = addHelper(head);
		if(carry==1) {
			Node newNode = new Node(1);
			newNode.next = head;
			return newNode;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr = {9,9,9};
		
		Node head = convertArr2LL(arr);
		display(head);
		Node newHead = addOne(head);
		display(newHead);
		
		head = convertArr2LL(arr);
		Node newHead2 = addOneII(head);
		display(newHead2);
	} 
	
}
