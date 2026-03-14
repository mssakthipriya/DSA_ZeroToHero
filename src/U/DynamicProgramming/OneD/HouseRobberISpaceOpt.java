package U.DynamicProgramming.OneD;

public class HouseRobberISpaceOpt {
	
	public static int getMaxLoot(int[] money) {
		int prev1=money[0];
		int prev2 = 0;
		for(int i=1;i<money.length;i++) {
			int pick = prev2+money[i];
			int notPick = prev1;
			int curr = Math.max(pick, notPick);
			prev2 = prev1;
			prev1=curr;
		}		

		return prev1;
	}
	public static void main(String[] args) {
		int[] money = {2,1,4,9};
		
		int maxMoney = getMaxLoot(money);
		
		System.out.println(maxMoney);
	}

}
