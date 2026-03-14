package N.StackAndQueue;

import java.util.Stack;

public class BalancedParenthesesChecker {

	public static boolean isBalancedParentheses(String s) {
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0;i<s.length();i++) {
			//'(', ')', '{', '}', '[' and ']'
			if((s.charAt(i)=='(') || (s.charAt(i)=='{') ||(s.charAt(i)=='[')) {
				st.push(s.charAt(i));
			}else {
				if(st.isEmpty()) return false;
				if(((s.charAt(i)==')')&&(st.peek()=='('))||((s.charAt(i)=='}')&&(st.peek()=='{'))||((s.charAt(i)==']')&&(st.peek()=='['))) {
					st.pop();
				}else {
					return false;
				}
			}
		}
		
		return st.isEmpty();
	}
	public static void main(String[] args) {
		String str = "()[{}()]";
		
		boolean check = isBalancedParentheses(str);
		
		System.out.println(check);
	}
}
