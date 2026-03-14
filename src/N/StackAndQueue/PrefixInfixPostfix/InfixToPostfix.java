package N.StackAndQueue.PrefixInfixPostfix;

import java.util.Stack;

public class InfixToPostfix {
	
	public static int getPrecedence(char c) {
		
		switch(c) {
		case '^':
			return 3;
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;		
		}
		return -1;
	}

	public static String getPostfixExp(String infix) {
		String postfix="";
		Stack<Character> st = new Stack<>();
		
		for(int i=0;i<infix.length();i++) {
			char c = infix.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				postfix+=c;
			}else if(c=='(') {
				st.push(c);
			}else if(c==')') {
				while(!st.isEmpty()&& st.peek()!='(') {
					postfix += st.pop();
				}
				st.pop();
			}else {
				while(!st.isEmpty() && getPrecedence(c)<=getPrecedence(st.peek())) {
					postfix+=st.pop();
				}
				st.push(c);
			}
		}
		
		
		while(!st.isEmpty()) {
			if(st.peek()=='(') return "invalid expression!";
			postfix+=st.pop();
		}
		
		return postfix;
	}
	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)^(f+g*h)-i";
		//String infix = "a+b";
		
		String postfix = getPostfixExp(infix);
		
		System.out.println("Postfix expression is: "+postfix);
	}
}
