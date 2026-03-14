package K.LinkedList.Hard;

class Nodes{
	int data;
	Nodes next;
	Nodes random;
	
	public Nodes(int data) {
		this.data=data;
		this.next=null;
		this.random=null;
	}
}

public class CloneWithRandom {
	public static Nodes convertArr2LL(int[] arr) {
		Nodes head = new Nodes(arr[0]);
		Nodes temp=head;
		for(int i=1;i<arr.length;i++) {
			Nodes newNode = new Nodes(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
		head.random=null;
		head.next.random=head;
		head.next.next.random=head.next.next.next.next;
		head.next.next.next.random=head.next.next.next;
		head.next.next.next.next.random=head;
				
		return head;
	}
	public static void printClonedLinkedList(Nodes head) {
	    while (head != null) {
	        System.out.print("Data: " + head.data);
	        if (head.random != null) {
	            System.out.print(", Random: " + head.random.data);
	        } else {
	            System.out.print(", Random: null");
	        }
	        System.out.println();
	        // Move to the next node
	        head = head.next;
	    }
	}
	
	public static void display(Nodes head) {
		Nodes current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	public static void insertCopyInbetween(Nodes head) {
		Nodes temp = head;
		while(temp!=null) {
			Nodes nextElm = temp.next;
			Nodes copy = new Nodes(temp.data);
			copy.next=nextElm;
			temp.next=copy;
			temp=nextElm;
		}
	}
	public static void connectRandomPointers(Nodes head) {
		Nodes temp=head;
		while(temp!=null) {
			Nodes copy = temp.next;
			if(temp.random!=null) {
				copy.random=temp.random.next;
			}else {
				copy.random=null;
			}
			temp=temp.next.next;
		}
	}
	public static Nodes getDeepCopyList(Nodes head) {
		Nodes temp=head;
		Nodes dummy = new Nodes(-1);
		Nodes res = dummy;
		while(temp!=null) {
			res.next=temp.next;
			res=res.next;
			
			temp.next=temp.next.next;
			temp=temp.next;
		}
		return dummy.next;
	}
	
	public static Nodes cloneLL(Nodes head) {
		if(head==null) return null;
		
		insertCopyInbetween(head);
		connectRandomPointers(head);
		
		return getDeepCopyList(head);
	}
	
	public static void main(String[] args) {
		int[] arr= {7,13,11,10,1};
		Nodes head = convertArr2LL(arr);
		display(head);
		printClonedLinkedList(head);
		Nodes clonedHead = cloneLL(head);
		display(clonedHead);
		printClonedLinkedList(clonedHead);
		
		

		
	}
}
