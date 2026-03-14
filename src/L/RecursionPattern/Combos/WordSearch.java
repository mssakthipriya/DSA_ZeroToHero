package L.RecursionPattern.Combos;

public class WordSearch {
	public static boolean checkWord(char[][] board,String word,int index,int row,int col,int m,int n) {
		if(index==word.length()) {
			return true;
		}
		
		if(row<0||col<0||row==m||col==n||board[row][col]!=word.charAt(index)||board[row][col]=='!') {
			return false;
		}
		
		char c=board[row][col];
		//System.out.println(c);
		board[row][col]='!';
		
		boolean top = checkWord(board,word,index+1,row+1,col,m,n);
		boolean bottom = checkWord(board,word,index+1,row-1,col,m,n);
		boolean left = checkWord(board,word,index+1,row,col-1,m,n);
		boolean right = checkWord(board,word,index+1,row,col+1,m,n);
		
		board[row][col]=c;
		System.out.println("top:"+top+";bottom:"+bottom+";left:"+left+";right:"+right);
		System.out.println("index:"+index+",ans:"+(top||bottom||left||right));
		return top||bottom||left||right;
	}
	public static boolean findWord(char[][] board,String word) {
		int m=board.length;
		int n=board[0].length;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(checkWord(board,word,0,i,j,m,n))
					return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="ABCCED";
		
		System.out.println(findWord(board,word));
	}

}
