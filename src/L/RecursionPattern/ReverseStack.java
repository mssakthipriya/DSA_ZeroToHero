package L.RecursionPattern;

import java.util.Stack;

public class ReverseStack {

	public static void insertAtBottom(Stack<Integer> s,int x) {
		if(s.isEmpty()) {
			s.push(x);
		}else {
			int a = s.pop();
			insertAtBottom(s, x);
			s.push(a);
		}
	}
	public static Stack<Integer> reverse(Stack<Integer> s) {
		if(s.size()==0) {
			return s; 
		}
		int x=s.pop();
		reverse(s);
		insertAtBottom(s,x);
		return s;
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);
		Stack<Integer>revS = reverse(s);
		System.out.println(revS);
	}
}
