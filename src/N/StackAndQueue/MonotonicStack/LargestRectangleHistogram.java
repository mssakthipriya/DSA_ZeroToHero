package N.StackAndQueue.MonotonicStack;

import java.util.Stack;

public class LargestRectangleHistogram {
	
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++) {
        	while(!st.isEmpty() && (i==n ||heights[st.peek()]>=( i<n?heights[i]:0))) {
        		int index = st.pop();
        		int width = st.isEmpty()? i:(i-st.peek()-1);
        		area = Math.max(area,heights[index]*width );        		
        	}
        	
        	st.push(i);
        }
        return area;
    }
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		
		int area = largestRectangleArea(heights);
		
		System.out.println(area);
	}

}
