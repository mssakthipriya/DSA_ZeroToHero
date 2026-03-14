package U.DynamicProgramming.OneD;

public class HouseRobberIISpaceOpt {
	
	public static int getMaxLootHelper(int[] money) {
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
