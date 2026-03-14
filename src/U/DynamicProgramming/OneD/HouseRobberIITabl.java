package U.DynamicProgramming.OneD;


public class HouseRobberIITabl {	

	public static int getMaxLootHelper(int[] money) {
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
