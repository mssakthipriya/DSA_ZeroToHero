package U.DynamicProgramming.OneD;


public class HouseRobberITabl {	

	public static int getMaxLoot(int[] money) {
		int[] dp = new int[money.length];
		dp[0]=money[0];
		for(int i=1;i<money.length;i++) {
			int pick = money[i];
			if(i>1) {
				pick = dp[i-2]+money[i];
			}
			int notPick = dp[i-1];
			dp[i] = Math.max(pick, notPick);
		}		
		
		
		int maxLoot = dp[money.length-1];
	
		return maxLoot;
	}
	public static void main(String[] args) {
		int[] money = {2,1,4,9};
		
		int maxMoney = getMaxLoot(money);
		
		System.out.println(maxMoney);
	}

}
