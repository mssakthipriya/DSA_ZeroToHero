package N.StackAndQueue;

import java.util.Stack;

public class QueueusingStack {
	Stack<Integer> input = new Stack<>(); 
	Stack<Integer> output = new Stack<>();
	
	public void push(int x) {
		input.push(x);
	}
	public int pop() {
		if(output.isEmpty()) {
			while(!input.isEmpty()) {
				output.push(input.peek());
				input.pop();
			}
		}
		int x = output.peek();
		output.pop();
		
		return x;
	}
	
	public int peek() {
		if(output.isEmpty()) {
			while(!input.isEmpty()) {
				output.push(input.peek());
				input.pop();
			}
		}
		int x = output.peek();
		
		return x;
	}
	
	public static void main(String[] args) {
		QueueusingStack q = new QueueusingStack();
		q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
	}
	
}
