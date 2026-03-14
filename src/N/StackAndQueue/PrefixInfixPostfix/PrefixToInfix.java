package N.StackAndQueue.PrefixInfixPostfix;
/***

    Traverse the prefix expression from right to left.
    Use a stack to store operands.
    For each operator, pop two operands from the stack, wrap them in parentheses, and push the resulting expression back.
    The final item in the stack will be the infix expression.
 
 ***/
import java.util.Stack;

public class PrefixToInfix {
	
	public static String getInfix(String prefix) {
		String infix = "";
		Stack<String> st =  new Stack<>();
		
		for(int i=prefix.length()-1;i>=0;i--) {
			char c = prefix.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				st.push(String.valueOf(c));
			}else {
				String operand1 = st.pop();
				String operand2 = st.pop();
				String operation="("+operand1+c+operand2+")";
				st.push(operation);
			}
		}
		
		infix = st.pop();
		
		
		return infix;
	}
	public static void main(String[] args) {
		String prefix = "*+ab-cd";
		
		String infix = getInfix(prefix);
		System.out.println("The infix expression is: "+infix);
	}

}
