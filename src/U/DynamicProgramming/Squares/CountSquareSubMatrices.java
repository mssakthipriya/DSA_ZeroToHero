package U.DynamicProgramming.Squares;

public class CountSquareSubMatrices {
	
    public static int countSquares(int[][] matrix) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++) {
        	dp[i][0]=matrix[i][0];
        }
        
        for(int j=0;j<m;j++) {
        	dp[0][j] = matrix[0][j];
        }
        
        for(int i=1;i<n;i++) {
        	for(int j=1;j<m;j++) {
        		if(matrix[i][j]==0) {
        			dp[i][j]=0;
        		}else {
            		int min  = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
            		dp[i][j] = min+1;
        		}

        	}
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		count+=dp[i][j];
        	}
        }
        
        
        return count;
    }
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1,0,1},
						  {1,1,0},
						  {1,1,0}};
		
		int count = countSquares(matrix);
		
		System.out.println(count);
	}

}
