package U.DynamicProgramming.OneD;

public class ClimbingStairsSpaceOpt {
	
	public static int getClimbCount(int n) {
		int prev1=1;
		int prev2=1;
		int curr=0;
		for(int i=2;i<=n;i++) {
			curr=prev1+prev2;
			prev1=prev2;
			prev2=curr;
		}
		
		return curr;	
	}
	public static void main(String[] args) {
		int n=4;
		
		System.out.println(getClimbCount(n));
	}

}
