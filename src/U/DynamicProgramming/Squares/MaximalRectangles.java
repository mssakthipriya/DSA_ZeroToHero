package U.DynamicProgramming.Squares;

import java.util.Stack;

public class MaximalRectangles {
	
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		
		int maxArea = 0;
		
		for(int i=0;i<=n;i++) {
			
			while(!st.isEmpty()&&(i==n || heights[st.peek()]>=(i<n?heights[i]:0))) {
				int height = heights[st.pop()];
				int width = 0;
				if(st.isEmpty()) {
					width = i;
				}else{
					width = i-st.peek()-1;
				}
				maxArea = Math.max(maxArea, width*height);
			}
			st.push(i);
		}
		
		
		
		return maxArea;
	}
	
	public static int maximalRectangle(char[][] matrix) {
		
		if (matrix.length == 0) return 0;
		
		int n = matrix.length;
		int m = matrix[0].length;
		int[] heights = new int[m];
		int maxArea = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(matrix[i][j]=='1') {
					heights[j]++;
				}else {
					heights[j]=0;
				}
			}
			
			maxArea = Math.max(maxArea, largestRectangleArea(heights));
		}
		
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		
		int area = maximalRectangle(matrix);
		
		System.out.println(area);
	}

}
