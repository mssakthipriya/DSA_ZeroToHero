package L.RecursionPattern;

import java.util.Stack;

public class SortsStack {
	public static void helper(Stack<Integer> s,int x) {
		if(s.isEmpty()|| s.peek()<x) {
			s.push(x);
			return;
		}
		int a = s.pop();
		helper(s,x);
		s.push(a);
		
	}
	public static Stack<Integer> sortStack(Stack<Integer> s){
		if(s.isEmpty()) {
			return s;
		}
		int x = s.pop();
		sortStack(s);
		helper(s,x);
		
		return s;
		
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(3);
		s.push(2);
		s.push(4);
		s.push(1);
		System.out.println(s);
		Stack<Integer> sortedS = sortStack(s);
		System.out.println(sortedS);
	}

}
