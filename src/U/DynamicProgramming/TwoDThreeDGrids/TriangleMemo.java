package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMemo {
	public static int getSum(List<List<Integer>> tri,int m, int n,int[][] dp) {
		if(m==tri.size()-1) return tri.get(m).get(n);
		if(dp[m][n]!=-1) return dp[m][n];
		int down =tri.get(m).get(n)+ getSum(tri,m+1,n,dp);
		int diagonal = tri.get(m).get(n)+ getSum(tri,m+1,n+1,dp);
		
		
		return dp[m][n]=Math.min(down, diagonal);
	}
	public static int getMinPathSum(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		int sum = getSum(triangle,0,0,dp);
		return sum;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(new ArrayList<>(Arrays.asList(2)));
		triangle.add(new ArrayList<>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
		
		
		System.out.println(triangle.toString());
		
		int sum = getMinPathSum(triangle);
		
		System.out.println(sum);
	}

}
