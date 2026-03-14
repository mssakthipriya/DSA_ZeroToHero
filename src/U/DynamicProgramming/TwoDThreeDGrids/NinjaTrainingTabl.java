package U.DynamicProgramming.TwoDThreeDGrids;


public class NinjaTrainingTabl {

	public static int getTotalPoints(int[][] points,int days) {
		int act = 3;
		int[][] dp = new int[days][act+1];
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
		
		for(int i=1;i<days;i++) {
			for(int j=0;j<4;j++) {
				dp[i][j]=0;
				
				for(int k=0;k<=2;k++) {
					if(k!=j) {
						int maxPoints=points[i][k]+dp[i-1][k];
						dp[i][j] = Math.max(dp[i][j],maxPoints);
					}					
				}
			}
		}
		
		
		return dp[days-1][act];
	}
	public static void main(String[] args) {
		int days = 3;
		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
		
		int totalPoints = getTotalPoints(points,days);
		
		System.out.println(totalPoints);
	}

}
