package K.DoublyLinkedList.Medium;

public class DeleteAllOccurance {
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
	public static Node deleteOccurance(Node head, int k) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data==k) {
				if(temp==head) {
					head=temp.next;
				}
				
				Node prevNode = temp.prev;
				Node nextNode = temp.next;
				if(nextNode!=null) nextNode.prev=prevNode;
				if(prevNode!=null) prevNode.next=nextNode;
				temp.next=null;
				temp.prev=null;
				temp=nextNode;
				
			}else {
				temp=temp.next;
			}
		}
		
		return head;
	}
	public static void main(String[] args) {
		int[] arr = {10,4,10,10,6,10};
		Node head = convertArrToDLL(arr);
		display(head);
		int k=10;
		Node newHead = deleteOccurance(head,k);
		display(newHead);
	}

}
