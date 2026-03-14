package K.LinkedList.Medium;

public class PalindromeLL {
	public static Node convertArr2LL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp=head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
		
		return head;
	}public static Node reverse(Node head) {
		Node prev = null;
		Node temp = head;
		while(temp!=null) {
			Node front=temp.next;
			temp.next=prev;
			prev = temp;
			temp = front;
		}
		return prev;
	}
	public static boolean checkPalindrome(Node head) {
		
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		
		Node newHead = reverse(slow.next);
		Node first = head;
		Node second = newHead;
		while(second!=null) {
		if(first.data!=second.data) {
			reverse(newHead);
			return false;
		}
		first = first.next;
		second = second.next;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,1};
		Node head = convertArr2LL(arr);
		boolean check = checkPalindrome(head);
		System.out.println("Is the linked list a palindrome :"+check);
	}

}
