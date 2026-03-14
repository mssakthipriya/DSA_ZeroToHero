package U.DynamicProgramming.OneD;

public class FrogJumpISpaceOpt {

	public static int getMinEnergy(int[] e) {
		int n = e.length;
		int prev1=0;
		int prev2=0;
		for(int i=1;i<n;i++) {		
			int two = Integer.MAX_VALUE;
			int one = prev1+Math.abs(e[i]-e[i-1]);
			if(i>1) {
				two = prev2+Math.abs(e[i]-e[i-2]);
			}			
			int curr = Math.min(one, two);
			prev2 = prev1;
			prev1=curr;
		}
		
		return prev1;
	}
	public static void main(String[] args) {
		int[] energy = {10,20,30,10};
		
		int minEnergy = getMinEnergy(energy);
		
		System.out.println("minimum energy required to climb stairs:"+minEnergy);
	}

}
