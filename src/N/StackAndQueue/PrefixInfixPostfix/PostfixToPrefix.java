package N.StackAndQueue.PrefixInfixPostfix;

import java.util.Stack;

/*** 
    Traverse the postfix expression from left to right.
    Use a stack to store operands.
    For each operator, pop two operands, combine them with the operator in prefix order, and push the result back.
    The final item in the stack will be the prefix expression.
 ***/
public class PostfixToPrefix {
	
	public static String getPrefix(String postfix) {
		if(postfix.isEmpty()) return null;
		String prefix = "";
		Stack<String> st = new Stack<>();
		
		for(int i=0;i<postfix.length();i++) {
			char c = postfix.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				st.push(String.valueOf(c));
			}else {
				String operand2 = st.pop();
				String operand1 = st.pop();
				String operation = c+operand1+operand2;
				st.push(operation);
			}
		}
		
		prefix = st.pop();
		
		return prefix;
	}
	
	public static void main(String[] args) {
		String postfix = "abc*+d-";
		
		String prefix = getPrefix(postfix);
		System.out.println("The corresponding prefix expression is: "+ prefix);
	}

}
