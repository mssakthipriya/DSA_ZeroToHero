package U.DynamicProgramming.OneD;

import java.util.Arrays;

public class HouseRobberIIMemo {
	
	public static int solve(int[] money,int index,int[] dp) {		
		if(index==0) return money[index];
		if(index<0) return 0;
		
		if(dp[index]!=-1) return dp[index];
		
		int pick=money[index]+solve(money,index-2,dp);
		int notPick = solve(money,index-1,dp);
		
		return dp[index]=Math.max(pick, notPick);
	}
	public static int getMaxLootHelper(int[] money) {
		int[] dp = new int[money.length];	
		Arrays.fill(dp, -1);
		int maxLoot = solve(money,money.length-1,dp);
	
		return maxLoot;
	}
	public static int getMaxLoot(int[] money) {
		int[] temp1 = new int[money.length-1];
		int[] temp2 = new int[money.length-1];
		for(int i=0;i<money.length-1;i++) {
			temp1[i]=money[i];
			temp2[i]=money[i+1];
		}
		
		return Math.max(getMaxLootHelper(temp1), getMaxLootHelper(temp2));
	}
	public static void main(String[] args) {
		int[] money = {1,5,2,1,6};
		
		int maxMoney = getMaxLoot(money);
		
		System.out.println(maxMoney);
	}

}
