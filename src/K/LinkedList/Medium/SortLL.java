package K.LinkedList.Medium;

public class SortLL {
	public static Node convertArrToLL(int[] arr) {
		Node head =  new Node(arr[0]);
		Node temp = head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp=temp.next;
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
	public static Node getMiddle(Node head) {
		 if (head == null || head.next == null) {
		        return head;
		    }
		Node slow = head;
		Node fast = head.next;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static Node mergeSortedLL(Node left,Node right) {
		Node dummy = new Node(-1);
		Node temp = dummy;
		while(left!=null && right!=null) {
			if(left.data<=right.data) {
				temp.next=left;
				left=left.next;
			}else {
				temp.next=right;
				right = right.next;
			}
			temp = temp.next;
		}
		if(left!=null) temp.next=left;
		else temp.next=right;
		
		Node head = dummy.next;
		return head;
	}
	public static Node mergeSort(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node middle = getMiddle(head);
		//System.out.println(middle.data);
		Node rightHead = middle.next;
		middle.next = null;
		Node leftHead = head;
		rightHead = mergeSort(rightHead);
		leftHead = mergeSort(leftHead);
		
		return mergeSortedLL(leftHead,rightHead);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,1,5};
		Node head = convertArrToLL(arr);
		display(head);
		Node newHead = mergeSort(head);
		display(newHead);
		
	}
	

}
