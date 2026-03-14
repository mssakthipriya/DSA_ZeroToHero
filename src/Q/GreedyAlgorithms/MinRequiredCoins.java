package Q.GreedyAlgorithms;

import java.util.ArrayList;

public class MinRequiredCoins {

	public static int getMinCoins(int[] coins,int val) {
		int count=0;
		ArrayList<Integer> denoms = new ArrayList<>();
				
		for(int i=coins.length-1;i>=0;i--) {
			while(coins[i]<=val) {
				val-=coins[i];
				denoms.add(coins[i]);
				count++;
			}
		}
		
		System.out.println(denoms.toString());
		
		return count;
	}
	public static void main(String[] args) {
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int value = 1345;
		
		int count = getMinCoins(coins,value);
		
		System.out.println(count);
	}
}
