package K.LinkedList.Medium;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

public class MiddleOfLL {
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
	
	public static Node getMiddleNode(Node head) {
		Node middle=head;
		Node end = head;
		while(end!=null && end.next!=null) {
			middle=middle.next;
			end=end.next.next;
		}
		
		return middle;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = convertArr2LL(arr);
		Node middle = getMiddleNode(head);
		System.out.println("The middle node is :"+middle.data);
	}

}
