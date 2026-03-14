package N.StackAndQueue.PrefixInfixPostfix;

import java.util.Stack;

/***
 
    Traverse the postfix expression from left to right.
    Use a stack to store operands.
    For each operator, pop two operands, combine them in infix order with parentheses, and push the result back.
    The final item in the stack will be the infix expression.

 ***/
public class PostfixToInfix {

	public static String getInfix(String postfix) {
		if(postfix.isEmpty()) return null;
		String infix = "";
		Stack<String> st = new Stack<>();
		for(int i=0;i<postfix.length();i++) {
			char c = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				st.push(String.valueOf(c));
			}else {
				String operand2 = st.pop();
				String operand1 = st.pop();
				String operation = "("+operand1+c+operand2+")";
				st.push(operation);
			}
		}
		
		infix = st.pop();
			
		return infix;
	}
	public static void main(String[] args) {
		String postfix = "ab*cd/+";		
		
		String infix = getInfix(postfix);
		System.out.println("The infix expression is:"+ infix);
	}
}
