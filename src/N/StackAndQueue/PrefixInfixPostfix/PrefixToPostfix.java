package N.StackAndQueue.PrefixInfixPostfix;

import java.util.Stack;

/***
 
    Traverse the prefix expression from right to left.
    Use a stack to store operands.
    For each operator, pop two operands from the stack, combine them with the operator, and push the result back.
    The final item in the stack will be the postfix expression.

 ***/
public class PrefixToPostfix {
	
	public static String getPostfix(String prefix) {
		String postfix = "";
		Stack<String> st = new Stack<>();
		
		for(int i = prefix.length()-1;i>=0;i--) {
			char c = prefix.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				st.push(String.valueOf(c));
			}else {
				String operand1=st.pop();
				String operand2=st.pop();
				String operation = operand1+operand2+c;
				st.push(operation);
			}
		}
		
		postfix = st.pop();
		return postfix;
	}
	
	public static void main(String[] args) {
		
		String prefix = "*+ab-cd";
		
		String postfix = getPostfix(prefix);
		
		System.out.println("The corresponding postfix expression is:"+ postfix);
	}

}
