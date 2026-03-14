package N.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackusingQueue {
		Queue<Integer> q = new LinkedList<>();
		void push(int x) {
			q.add(x);
			for(int i=0;i<q.size()-1;i++) {
				q.add(q.remove());
				//System.out.println(q);
			}
		}
		
		int pop() {
			return q.remove();
		}
		int top() {
			return q.peek();
		}
		int size() {
			return q.size();
		}
	
	public static void main(String[] args) {
		StackusingQueue s = new StackusingQueue();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
	}

}
