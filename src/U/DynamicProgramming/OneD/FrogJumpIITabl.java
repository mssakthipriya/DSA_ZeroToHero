package U.DynamicProgramming.OneD;

public class FrogJumpIITabl {
	
	public static int getMinEnergy(int[] height,int k) {
		int[] dp = new int[height.length];
		
		for(int i=1;i<height.length;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=k;j++) {
				if(i-j>=0) {
					int jump = dp[i-j]+Math.abs(height[i]-height[i-j]);
					min = Math.min(min, jump);
				}
			}
			dp[i] = min;
		}
		
		return dp[height.length-1];
	}
	
	public static void main(String[] args) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
        int k = 2;
        
        int min = getMinEnergy(height,k);
        
        System.out.println(min);
	}

}
