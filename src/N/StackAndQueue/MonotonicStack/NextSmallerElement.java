package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

	public static int[] nextSmallest(int[] arr) {
		int n = arr.length;
		int[] next = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[i]<=st.peek()) {
				st.pop();
			}
			
			if(st.isEmpty()) {
				next[i] = -1;
			}else {
				next[i]=st.peek();
			}
			
			st.push(arr[i]);
		}
		
		return next;
	}
	public static void main(String[] args) {
		int[] arr = {4, 8, 5, 2, 25};
		
		int[] ans = nextSmallest(arr);
		
		System.out.println(Arrays.toString(ans));
	}
}
