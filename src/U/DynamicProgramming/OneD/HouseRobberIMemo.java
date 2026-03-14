package U.DynamicProgramming.OneD;

import java.util.Arrays;

public class HouseRobberIMemo {
	
	public static int solve(int[] money,int index,int[] dp) {		
		if(index==0) return money[index];
		if(index<0) return 0;
		
		if(dp[index]!=-1) return dp[index];
		
		int pick=money[index]+solve(money,index-2,dp);
		int notPick = solve(money,index-1,dp);
		
		return dp[index]=Math.max(pick, notPick);
	}
	public static int getMaxLoot(int[] money) {
		int[] dp = new int[money.length];	
		Arrays.fill(dp, -1);
		int maxLoot = solve(money,money.length-1,dp);
	
		return maxLoot;
	}
	public static void main(String[] args) {
		int[] money = {2,1,4,9};
		
		int maxMoney = getMaxLoot(money);
		
		System.out.println(maxMoney);
	}

}
