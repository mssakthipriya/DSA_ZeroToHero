package K.LinkedList.Medium;



public class DetectLoop {

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
	
	public static boolean checkLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Node head = convertArr2LL(arr);
		boolean flag = checkLoop(head);
		System.out.println("Is there a loop in the linked list? :"+flag);
	}
}
