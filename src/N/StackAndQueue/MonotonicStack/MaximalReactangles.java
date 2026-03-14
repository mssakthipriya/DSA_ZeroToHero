package N.StackAndQueue.MonotonicStack;


import java.util.Stack;

public class MaximalReactangles {
	public static int largestRectArea(int[] heights) {
		int n = heights.length;
		int area = 0;
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0;i<=n;i++) {
			while(!st.isEmpty() && ((i==n)||(heights[st.peek()]>=(i<n?heights[i]:0)))) {
				int index = st.pop();
				int width = st.isEmpty()?i:(i-st.peek()-1);
				area = Math.max(area, heights[index]*width);
			}
			st.push(i);
		}
		
		return area;
	}
    public static int maximalRectangle(char[][] matrix) {
        int area = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] heightMatrix = new int[n][m];
        
        for(int i=0;i<n;i++) {
        	System.out.println(i);
        	for(int j=0;j<m;j++) {
        		if(i==0) {
        			if(matrix[i][j]=='1') {
        				heightMatrix[i][j]=1;
        			}
        		}else {
        			if(matrix[i][j]=='1') {
        				heightMatrix[i][j]=heightMatrix[i-1][j]+1;
        			}
        		}
        	}
        }
        
        for(int[] heights : heightMatrix) {
        	//System.out.println(Arrays.toString(heights));
        	int rowArea = largestRectArea(heights);
        	area = Math.max(area, rowArea);
        }
        
        return area;
    }
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		
		int area = maximalRectangle(matrix);
		
		System.out.println(area);
	}

}
