package N.StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static int[] getNextGreaterEl(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			while(!st.isEmpty() && arr[i]>=st.peek()) {
				st.pop();
			}
			
			if(st.isEmpty()) {
				ans[i]=-1;
			}else {
				ans[i]=st.peek();
			}
			st.push(arr[i]);
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {3,10,4,2,1,2,6,1,7,2,9};
		
		int[] nextArr = getNextGreaterEl(arr);
		
		System.out.println(Arrays.toString(nextArr));
	}

}
