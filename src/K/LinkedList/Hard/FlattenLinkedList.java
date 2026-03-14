package K.LinkedList.Hard;


class Node{
	int data;
	Node next;
	Node child;
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

public class FlattenLinkedList {

	public static void display(Node head) {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	public static void printLL(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.child;
		}
		System.out.println();
	}
	public static void printOriginalLL(Node head, int depth) {
		while(head!=null) {
			System.out.print(head.data);
			if(head.child!=null) {
				System.out.print("->");
				printOriginalLL(head.child,depth+1);
			}
			if(head.next!=null) {
				System.out.println();
				for(int i=0;i<depth;++i) {
					System.out.print("| ");
				}
			}
			head = head.next;
		}
		
	}
	public static Node flattenLL(Node head) {
		if(head == null || head.next==null) {
			return head;
		}
		Node mergedHead = flattenLL(head.next);
		head = merge(head, mergedHead);
		return head;
	}
	public static Node merge(Node list1, Node list2) {
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		while(list1!=null && list2!=null) {
			if(list1.data<list2.data) {
				temp.child = list1;
				temp= list1;
				list1=list1.child;
			}else {
				temp.child=list2;
				temp = list2;
				list2=list2.child;
			}
			temp.next=null;
		}
		
		if(list1 !=null) {
			temp.child=list1;
		}else {
			temp.child=list2;
		}
		
		if(dummy.child!=null) {
			dummy.child.next=null;
		}
		return dummy.child;
	}
	public static void main(String[] args) {
		//create linked list with child pointers
		Node head = new Node(5);
		head.child = new Node(14);
		
		head.next = new Node(10);
		head.next.child = new Node(15);
		
		head.next.next = new Node(12);
		head.next.next.child = new Node(13);
		head.next.next.child.child = new Node(20);
		
		head.next.next.next=new Node(7);
		head.next.next.next.child=new Node(17);
		
		System.out.println("The original linked list:");
		printOriginalLL(head,0);
		System.out.println();
		
		Node flattenedLL = flattenLL(head);
		System.out.println("Flattened linked list is:");
		printLL(flattenedLL);
	}
	

}
