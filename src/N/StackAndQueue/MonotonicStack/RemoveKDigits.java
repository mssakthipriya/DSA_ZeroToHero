package N.StackAndQueue.MonotonicStack;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        String str = ""; 
        int n =  num.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++) {
        	char digit = num.charAt(i);
        	while(!st.isEmpty() && k>0 && st.peek()>digit) {
        		st.pop();
        		k--;
        	}
        	st.push(digit);
        }
        
        while(k>0) {
        	st.pop();
        	k--;
        }
        
        if(st.isEmpty()) return "0";
        
        while(!st.isEmpty()) {
        	str = st.pop()+str;
        }
        
        while(str.length()>0 && str.charAt(0)=='0') {
        	str=str.substring(1);
        }
        
        return str;
    }
	
	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		
		String ans = removeKdigits(num, k);
		
		System.out.println(ans);
	}

}
