package N.StackAndQueue;

public class QueueLL {
	QNode front;
	QNode rear;
	int size=0;
	
	class QNode{
		int data;
		QNode next;
		
		QNode(int data){
			this.data = data;
			next=null;
		}
	}
	
	public void enqueue(int data) {
		QNode newNode = new QNode(data);
		if(front==null) {
			front=rear=newNode;
		}else {
			rear.next=newNode;
			rear=newNode;
		}
		size++;
	}
	
	public int dequeue() {
		if(front==null) return -1;
		QNode temp = front;
		front = front.next;
		temp.next=null;
		size--;
		return temp.data;
	}
	
	public int peek() {
		if(front==null) return -1;
		else return front.data;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void print() {
		QNode temp = front;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	    QueueLL Q=new QueueLL();
	    Q.enqueue(10);
	    Q.enqueue(20);
	    Q.enqueue(30);
	    Q.enqueue(40);
	    Q.enqueue(50);
	    Q.dequeue();
	    System.out.println("The size of the Queue is "+Q.size);
	    System.out.println("The Peek element of the Queue is "+Q.peek());
	    
	    Q.print();
	}
}
