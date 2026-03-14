package K.LinkedList.Hard;

public class ReverseLLGroups {
	public static Node convertArr2LL(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp=head;
		for(int i=1;i<arr.length;i++) {
			Node newNode = new Node(arr[i]);
			temp.next=newNode;
			temp=temp.next;
		}
				
		return head;
	}
	
	public static void display(Node head) {
		Node current = head;
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.println();
	}
	
	public static Node reverse(Node head) {
		Node prev = null;
		Node temp = head;
		while(temp!=null) {
			Node front  = temp.next;
			temp.next=prev;
			prev=temp;
			temp=front;
		}
		return prev;
	}
	
	public static Node getKthNode(Node temp,int k) {
		k-=1;
		while(temp!=null && k>0) {
			k--;
			temp=temp.next;
		}
		return temp;
	}
	
	public static Node kReverse(Node head, int k) {
		Node temp = head;
		Node prevNode = null;

		while(temp!=null) {
			Node kthNode = getKthNode(temp, k);
			
			if(kthNode==null) {
				if(prevNode!=null) {
					prevNode.next=temp;
				}
				
				break;				
			}
			
			Node nextNode = kthNode.next;
			kthNode.next=null;
			reverse(temp);
			if(temp==head) {
				head = kthNode;
			}else {
				prevNode.next=kthNode;
			}

			prevNode = temp;
			temp=nextNode;
				
		}
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		int k = 3;
		Node head = convertArr2LL(arr);
		display(head);
		Node revHead = kReverse(head,k);
		display(revHead);
		
	}
}
