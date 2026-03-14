package K.LinkedList.Medium;



public class StartofLoop {

	public static Node convertArr2LL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp=head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
		
		temp.next=head.next.next.next;
		
		return head;
	}
	
	public static int getLoopStart(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				slow=head;
				while(slow!=fast) {
				slow=slow.next;
				fast=fast.next;
				}
				return slow.data;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = convertArr2LL(arr);
		int start = getLoopStart(head);
		System.out.println("The starting point of the loop is :"+start);
	}
}
