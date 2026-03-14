package K.LinkedList.Medium;



public class LoopLength {

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
	
	public static int getLoopLength(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return findLength(slow,fast); 
			}
		}
		return 0;
	}
	
	public static int findLength(Node slow,Node fast) {
		int count =1;
		fast = fast.next;
		while(slow!=fast){
			fast = fast.next;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = convertArr2LL(arr);
		int length = getLoopLength(head);
		System.out.println("The length of the loop in the linked list is; :"+length);
	}
}
