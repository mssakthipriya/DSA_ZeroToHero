package L.RecursionPattern.Combos;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void findQueens(int col,char[][] board,List<List<String>> ans,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal) {
		if(col==board.length) {
			ans.add(construct(board));
			return;
		}
		
		for(int row=0;row<board.length;row++) {
			if(leftRow[row]==0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length-1+col-row]==0) {
				board[row][col]='Q';
				leftRow[row]=1;
				lowerDiagonal[row+col]=1;
				upperDiagonal[board.length-1+col-row]=1;
				findQueens(col+1,board, ans,leftRow,upperDiagonal,lowerDiagonal);
				board[row][col]='.';
				leftRow[row]=0;
				lowerDiagonal[row+col]=0;
				upperDiagonal[board.length-1+col-row]=0;
			}
		}
	}
	public static List<List<String>> nQueens(int n){
		char[][] board = new char[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j]='.';
			}
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		int[] leftRow = new int[n];
		int[] upperDiagonal = new int[2*n-1];
		int[] lowerDiagonal = new int[2*n-1];
		findQueens(0,board, ans,leftRow,upperDiagonal,lowerDiagonal);
		
		return ans;
	}
	public static List<String> construct(char[][] board){
		List<String> res = new ArrayList<String>();
		for(int i=0;i<board.length;i++) {
			String s  = new String(board[i]);
			res.add(s);
		}
		
		return res;
	}
	public static void main(String[] args) {
		int n=4;
		
		List<List<String>> combinations = nQueens(n);
		
		for(List<String> it:combinations) {
			for(String s:it) {
				System.out.println(s);
			}
			System.out.println("-----------------");
		}
		
	}
	
}
