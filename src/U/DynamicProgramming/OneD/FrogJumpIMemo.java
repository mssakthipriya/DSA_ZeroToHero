package U.DynamicProgramming.OneD;

import java.util.Arrays;

public class FrogJumpIMemo {
	
	public static int getMin(int[] e, int index,int[] dp) {
		if(index==0) return 0;
		if(dp[index]!=-1) return dp[index];
		
		int two = Integer.MAX_VALUE;
		int one = getMin(e,index-1,dp)+Math.abs(e[index]-e[index-1]);
		if(index>1) {
			two = getMin(e,index-2,dp)+Math.abs(e[index]-e[index-2]);
		}
		return dp[index]=Math.min(one,two);
	}
	public static int getMinEnergy(int[] e) {
		int[] dp = new int[e.length];
		Arrays.fill(dp, -1);
		int min = getMin(e,e.length-1,dp);
		
		return min;
	}
	public static void main(String[] args) {
		int[] energy = {10,20,30,10};
		
		int minEnergy = getMinEnergy(energy);
		
		System.out.println("minimum energy required to climb stairs:"+minEnergy);
	}

}
