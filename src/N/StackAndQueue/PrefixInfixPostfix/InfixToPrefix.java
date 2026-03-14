package N.StackAndQueue.PrefixInfixPostfix;

import java.util.Stack;

public class InfixToPrefix {
	public static String reverse(String str) {
		char[] strArr = str.toCharArray();
		int start = 0;
		int end = str.length()-1;
		char temp;
		while(start<end) {
			temp=strArr[start];
			strArr[start]=strArr[end];
			strArr[end]=temp;
			start++;
			end--;
		}
		return String.valueOf(strArr);
	}
	public static int precedence(char c) {
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
	public static boolean isRightAssociative(char c) {
		return c=='^';
	}
	public static String getPrefixExp(String infix) {
		String prefix = "";
		Stack<Character> st = new Stack<>();
		for(int i=infix.length()-1;i>=0;i--) {
			char c = infix.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				prefix+=c;
			}else if(c==')') {
				st.push(c);
			}else if(c=='(') {
				while(!st.isEmpty() && st.peek()!=')') {
					prefix+=st.pop();
				}
				if(!st.isEmpty()) {
					st.pop();
				}
			}else {
				while(!st.isEmpty() && (precedence(c)<precedence(st.peek()) || (precedence(c)==precedence(st.peek()) && isRightAssociative(c)))) {
					prefix+=st.pop();
				}
				st.push(c);
			}
		}
		
		while(!st.isEmpty()) {
			prefix+=st.pop();
		}
		
		prefix = reverse(prefix);
		
		return prefix;
	}
	public static void main(String[] args) {
		//String infix = "a+b";
		String infix = "x+y*z/w+u";
		
		String prefix = getPrefixExp(infix);
		
		System.out.println("The prefix expression is: "+prefix);
	}

}
