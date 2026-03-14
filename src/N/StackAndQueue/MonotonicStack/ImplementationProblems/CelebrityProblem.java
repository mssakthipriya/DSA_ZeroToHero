package N.StackAndQueue.MonotonicStack.ImplementationProblems;

import java.util.Stack;

public class CelebrityProblem {
	public static int getCelebrity(int[][] matrix) {
		int n = matrix.length;
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<n;i++) {
			st.push(i);
		}
		while(st.size()>1) {
			int a  = st.pop();
			int b = st.pop();
			if(matrix[a][b]==1) {
				st.push(b);
			}else {
				st.push(a);
			}
		}
		
		int celeb = st.pop();
		for(int i=0;i<n;i++) {
			if(i==celeb) continue;
			if(matrix[celeb][i]==1 ||matrix[i][celeb]==0) {
				return -1;
			}
		}
		
		return celeb;
	}
	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 0},{0, 0, 0, 0},{1, 1, 0, 0},{0, 1, 1, 0}};
		
		int celebrity = getCelebrity(matrix);
		
		System.out.println(celebrity);
	}

}
