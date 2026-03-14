package U.DynamicProgramming.OneD;

public class FrogJumpITabl {

	public static int getMinEnergy(int[] e) {
		int n = e.length;
		int[] dp = new int[n];
		for(int i=1;i<n;i++) {
			int two = Integer.MAX_VALUE;
			int one = dp[i-1]+Math.abs(e[i]-e[i-1]);
			if(i>1) {
			 two = dp[i-2]+Math.abs(e[i]-e[i-2]);
			}
			dp[i] = Math.min(one, two);
		}
		
		return dp[n-1];
	}
	public static void main(String[] args) {
		int[] energy = {10,20,30,10};
		
		int minEnergy = getMinEnergy(energy);
		
		System.out.println("minimum energy required to climb stairs:"+minEnergy);
	}

}
