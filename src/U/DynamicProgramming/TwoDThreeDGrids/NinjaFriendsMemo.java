package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class NinjaFriendsMemo {

	public static int solve(int r, int c1, int c2, int n, int m, int[][] grid, int[][][] dp) {
		
		if(c1<0 || c1>=m ||c2<0 ||c2>=m) return (int)(-1e8);
		
		if(r==n-1) {
			if(c1==c2) return grid[r][c1];
			else return grid[r][c1]+grid[r][c2];
		}
		
		if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];
		
		int maxi = (int)(-1e8);
		int curr = (c1==c2)? grid[r][c1]:grid[r][c1]+grid[r][c2];
		
		for(int dc1=-1;dc1<=1;dc1++) {
			for(int dc2=-1;dc2<=1;dc2++) {
				int ans = curr+ solve(r+1, c1+dc1, c2+dc2, n, m, grid, dp);
				maxi = Math.max(maxi, ans);
			}
		}
		
		
		return dp[r][c1][c2] = maxi;
	}
    public static int cherryPickup(int[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;
    	int[][][] dp = new int[n][m][m];
    	
    	for(int[][] arr1 : dp) {
    		for(int[] arr2 : arr1) {
    			Arrays.fill(arr2, -1);
    		}
    	}
    	
    	return solve(0,0,m-1,n,m,grid,dp);
        
    }
	public static void main(String[] args) {
		int [][] grid =  {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		
		int maxCherries = cherryPickup(grid);
		
		System.out.println(maxCherries);
	}

}
