package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
	public static int[] getNextGreaterEl(int[] arr) {
		int n = arr.length;
		int[] next = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=2*n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[i%n]>=st.peek()) {
				st.pop();
			}
			if(i<n) {
				if(!st.isEmpty())
					next[i] = st.peek();
				else next[i] = -1;
			}
			
			st.push(arr[i%n]);
		}
		
		return next;
	}
	public static void main(String[] args) {
		
		int[] arr = {3,10,4,2,1,2,6,1,7,2,9};
		
		int[] nextArr = getNextGreaterEl(arr);		
		System.out.println(Arrays.toString(nextArr));
	}
}
