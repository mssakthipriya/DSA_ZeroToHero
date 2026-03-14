package N.StackAndQueue;

public class ArrayQueue {
	private int[] a;
	int front;
	int rear;
	int maxSize;
	
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		front=-1;
		rear=-1;
		a=new int[maxSize];
	}
	
	public boolean isFull() {
		return (rear+1)%maxSize==front;
	}
	
	public boolean isEmpty() {
		return front==-1;
	}
	
	public void enqueue(int n) {
		if(isFull()) {
			System.out.println("The queue is full!");
			return;
		}
		if(front==-1)front=0;
		rear=(rear+1)%maxSize;
		a[rear]=n;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("The queue is empty");
			return -1;
		}
		int x  = a[front];
		
		if(front==rear) front=rear=-1;
		else front=(front+1)%maxSize;
		return x;
	}
	
	public void display() {
	    System.out.println("display----------");
	    if (isEmpty()) {
	        System.out.println("Queue is empty");
	        return;
	    }

	    int i = front;
	    while (true) {
	        System.out.println(a[i]);
	        if (i == rear) break;
	        i = (i + 1) % maxSize;
	    }
	}
	
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(5);
		q.enqueue(8);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display();
		q.dequeue();
		q.enqueue(5);
		q.display();
	}

}
