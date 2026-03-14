package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class NinjaFriendsTabl {
	
    public static int cherryPickup(int[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;
    	int[][][] dp = new int[n][m][m];
    	
    	for(int[][] arr1 : dp) {
    		for(int[] arr2 : arr1) {
    			Arrays.fill(arr2, -1);
    		}
    	}
    	
    	for(int c1=0;c1<m;c1++) {
    		for(int c2=0;c2<m;c2++) {
    			if(c1==c2)dp[n-1][c1][c2]= grid[n-1][c1];
    			else dp[n-1][c1][c2]= grid[n-1][c1]+grid[n-1][c2];
    		}
    	}
    	
    	for(int r = n-2; r>=0;r--) {
			for(int c1=0;c1<m;c1++) {
				for(int c2=0;c2<m;c2++) {
					int maxi = (int)(-1e8);
					int curr = (c1==c2)?grid[r][c1]:grid[r][c1]+grid[r][c2];
					
					for(int dc1 = -1;dc1<=1;dc1++) {
						for(int dc2 = -1;dc2<=1;dc2++) {
							int newc1 = c1+dc1;
							int newc2 = c2+dc2;
							if(newc1>=0 && newc1<m && newc2>=0 && newc2<m) {
								int ans = curr+dp[r+1][newc1][newc2];
								maxi = Math.max(maxi, ans);
							}else {
								maxi = Math.max(maxi, (int)(-1e8));
							}

						}
					}
					dp[r][c1][c2] = maxi;
				}
			}
    	}
    	
    	return dp[0][0][m-1];
        
    }
	public static void main(String[] args) {
		int [][] grid =  {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
		
		int maxCherries = cherryPickup(grid);
		
		System.out.println(maxCherries);
	}
}
