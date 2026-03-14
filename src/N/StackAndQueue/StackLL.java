package N.StackAndQueue;

public class StackLL {
	SNode top;
	int size;
	
	class SNode{
		int data;
		SNode next;
		
		SNode(int data){
			this.data=data;
			next = null;
		}
	}
	
	public void push(int x) {
		SNode newNode = new SNode(x);
				
		newNode.next=top;
		top=newNode;
		size++;
		
	}
	
	public int peek() {
		return top.data;
	}
	
	public int stackSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int pop() {
		if(top==null) return -1;
		SNode temp = top;
		top=top.next;
		temp.next=null;
		size--;
		return temp.data;
	}
	
	public void print() {
		SNode temp = top;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	    StackLL s = new StackLL();
	    s.push(10);
	    s.push(20);
	    s.print();
	    System.out.println("Element popped " + s.pop());
	    System.out.println("Stack size: " + s.stackSize());
	    System.out.println("Stack is empty or not: " + s.isEmpty());
	}

}
