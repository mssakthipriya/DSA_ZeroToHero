package K.LinkedList.Medium;

public class Intersection {

	public static Node convertArrToLL(int[] arr){
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
		
		return head;
	}
	public static void joinLL(Node head1, Node head2) {
		Node t1=head1;
		Node t2=head2;
		while(t2.next.data!=2)t2=t2.next;
		while(t1.data!=2)t1=t1.next;
		t2.next=t1;
	}
	public static void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	public static Node reverse(Node head) {
		Node prev = null;
		Node temp = head;
		while(temp!=null) {
			Node front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;			
		}
		
		return prev;
	}
	public static Node getIntersection(Node head1, Node head2) {
		Node t1 = head1;
		Node t2=head2;
		if(head1==null || head2==null) return null;
		while(t1!=t2) {
			t1=t1.next;
			t2=t2.next;
			
			if(t1==t2) return t1;
			
			if(t1==null) t1=head2;
			if(t2==null) t2=head1;
		}
		
		return t1;
		}
		
	public static Node getIntersectionII(Node head1, Node head2) {
	    if (head1 == null || head2 == null) return null;
	    Node rev1 = reverse(head1);
	    Node rev2 = reverse(head2);
	    
	    Node prev = null;
	    Node curr1 = rev1;
	    Node curr2 = rev2;

	    while (curr1 != null && curr2 != null) {
	        if (curr1 != curr2) { 
	            break;
	        }
	        prev = curr1;
	        curr1 = curr1.next;
	        curr2 = curr2.next;
	    }

	    // Restore the original lists
	    head1 = reverse(rev1);
	    head2 = reverse(rev2);

	    return prev; 
	}
	public static void main(String[] args) {
		int[] arr1 = {1,3,1,2,4};
		int[] arr2 = {3,2,4};
		Node head1 = convertArrToLL(arr1);
		Node head2 = convertArrToLL(arr2);
		joinLL(head1,head2);
		display(head1);
		display(head2);
		Node intersection = getIntersection(head1,head2);
		if(intersection==null) System.out.println(-1);
		else System.out.println(intersection.data);
		
	}


}
