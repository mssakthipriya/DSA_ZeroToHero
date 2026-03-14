package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleTabl {

	public static int getMinPathSum(List<List<Integer>> triangle) {
		int m = triangle.size();		
		int[][] dp = new int[m][m];
		dp[0][0] = triangle.get(0).get(0);
		for(int i=1;i<m;i++) {
			int n = triangle.get(i).size();
			dp[i][0] = triangle.get(i).get(0)+dp[i-1][0];
			for(int j=1;j<n;j++) {
				dp[i][j] = triangle.get(i).get(j)+Math.min(dp[i-1][j-1],dp[i-1][j]);
			}
			
			dp[i][n-1] = triangle.get(i).get(n-1)+dp[i-1][n-2];
		}
		int ans = Integer.MAX_VALUE;
		for(int j=0;j<m;j++) {
			ans = Math.min(ans, dp[m-1][j]);
		}
		
		return ans;
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
