package Q.GreedyAlgorithms.MediumHard;

public class JumpGameII {
    public static int jump(int[] nums) {
        int jumpCount = 0;
        int dest = nums.length-1;
        int jumpPoint = 0;
        int coverage = 0;
        for(int i=0;i<dest;i++) {
        	coverage = Math.max(coverage, i+nums[i]);
        	
        	if(i == jumpPoint) {
        		jumpPoint = coverage;
        		jumpCount++;
        		
            	if(coverage>=dest) {
            		return jumpCount;
            	}
        	}
        	
        }
        return jumpCount;
    }
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		
		int jumpCount = jump(nums);
		
		System.out.println(jumpCount);
	}

}
