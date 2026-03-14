package N.StackAndQueue;

public class ArrayStack {
	int top;
	int cap;
	int[] a;
	
	public ArrayStack(int cap) {
		this.cap = cap;
		a = new int[cap];
		top = -1;
	}
	
	public boolean push(int x) {
		if(top>=cap-1) {
			System.out.println("Stack overflow!");
			return false;
		}
		a[++top]=x;
		return true;
	}
	
	public int pop() {
		if(top<0) {
			System.out.println("Stack is empty!");
			return 0;
		}
		int x = a[top];
		a[top]=0;
		top=top-1;
		
		return x;
	}
	public int peek() {
		if(top<0) {
			System.out.println("Stack is empty!");
			return 0;
		}
				
		return a[top];
	}
	
	public boolean isEmpty() {
		return top<0;
	}
	
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		stack.pop();
		stack.peek();
		stack.push(1);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
	}
}
