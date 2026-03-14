package U.DynamicProgramming.TwoDThreeDGrids;

public class UniquePathsTabl {

	public static int getUniquePaths(int m,int n) {
		int[][] maze = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0) maze[i][j]=1;
				else maze[i][j] = maze[i-1][j]+maze[i][j-1];
			}
		}
		
		return maze[m-1][n-1];		
	}
	
	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		
		int count = getUniquePaths(m,n);
		
		System.out.println(count);
	}

}
