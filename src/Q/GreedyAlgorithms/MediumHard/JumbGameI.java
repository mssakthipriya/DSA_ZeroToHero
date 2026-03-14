package Q.GreedyAlgorithms.MediumHard;

public class JumbGameI {
    public static boolean canJump(int[] nums) {
       int maxLength = 0;
       
       for(int i=0;i<nums.length;i++) {
    	   if(i>maxLength) {
    		   return false;
    	   }
    	   maxLength = Math.max(maxLength, i+nums[i]);
       }
    	return true;
    }
    
    public static boolean canJump2(int[] nums) {
        int finishLine = nums[nums.length-1];
        
        for(int i=nums.length-1;i>=0;i--) {
     	   if(i+nums[i]>=finishLine) {
     		   finishLine = i;
     	   }
     	   
        }
     	return finishLine==0;
     }
	
	public static void main(String[] args) {
		int[] nums = {4, 3, 7, 1, 2};
		
		boolean check = canJump(nums);
		
		System.out.println(check);
		
        boolean check2 = canJump2(nums);
		
		System.out.println(check2);
	}

}
