package N.StackAndQueue.MonotonicStack.ImplementationProblems;

import java.util.Stack;

public class StockSpanner {
	private Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
    	int result = 1;
    	while(!st.isEmpty() && st.peek()[0]<=price) {
    		result+=st.pop()[1];
    	}
    	
    	st.push(new int[] {price,result});
    	
    	return result;
    }
	public static void main(String[] args) {
		StockSpanner sp = new StockSpanner();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
		
	}
}
