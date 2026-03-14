package K.LinkedList.Medium;

public class SortLL012 {
	public static Node convertArrToLL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i=1;i<arr.length;i++){
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp = temp.next;
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
	public static Node sort012(Node head) {
		Node zeroHead=new Node(-1);
		Node oneHead=new Node(-1);
		Node twoHead=new Node(-1);
		
		Node zero = zeroHead;
		Node one = oneHead;
		Node two = twoHead;
		
		Node temp=head;
		
		while(temp!=null) {
			if(temp.data==0) {
				zero.next=temp;
				zero=zero.next;
			}else if(temp.data==1) {
				one.next=temp;
				one=one.next;
			}else {
				two.next=temp;
				two=two.next;
			}	
			temp=temp.next;
		}
		zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
		one.next=twoHead.next;
		two.next = null;
		Node newHead = zeroHead.next;
		
		
		return newHead;
	}

	public static void main(String[] args) {
		int[] arr = {1,0,1,2,0,2,1};
		Node head = convertArrToLL(arr);
		display(head);
		Node newHead = sort012(head);
		display(newHead);
	}
}
