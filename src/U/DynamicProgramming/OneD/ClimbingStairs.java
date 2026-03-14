package U.DynamicProgramming.OneD;

public class ClimbingStairs {
	public static int[] dp = new int[46];
	
	public static int getClimbCount(int n) {
		if(n<=1) return 1;
		
		if(dp[n]!=0) return dp[n];
		
		return dp[n] = getClimbCount(n-1)+getClimbCount(n-2);		
	}
	public static void main(String[] args) {
		int n=4;
		
		System.out.println(getClimbCount(n));
	}

}
