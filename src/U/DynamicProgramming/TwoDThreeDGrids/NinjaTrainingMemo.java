package U.DynamicProgramming.TwoDThreeDGrids;

import java.util.Arrays;

public class NinjaTrainingMemo {
	public static int getPointsHelper(int[][] points,int day, int act,int[][] dp) {		
		if(day==0) {
			int max = 0;
			for(int i=0;i<3;i++) {
				if(i!=act) {
					max = Math.max(max,points[0][i]);
				}
			}
			return max;
		}
		if(dp[day][act]!=-1) return dp[day][act];
		int max=0;
		
		for(int i=0;i<3;i++) {
			if(i!=act) {
				int maxPoints=points[day][i]+getPointsHelper(points,day-1,i,dp);
				max = Math.max(max,maxPoints);
			}
			
		}
		return dp[day][act]= max;
		
	}
	public static int getTotalPoints(int[][] points,int days) {
		int act = 3;
		int[][] dp = new int[days][act+1];
		for(int[] row:dp) {
			Arrays.fill(row, -1);
		}
		int totPoints = getPointsHelper(points,days-1,act,dp);
		
		return totPoints;
	}
	public static void main(String[] args) {
		int days = 3;
		int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
		
		int totalPoints = getTotalPoints(points,days);
		
		System.out.println(totalPoints);
	}

}
