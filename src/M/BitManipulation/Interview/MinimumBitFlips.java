package M.BitManipulation.Interview;

public class MinimumBitFlips {
	
	public static int getMinBitFlips(int start, int goal) {
		int count = 0;
		
		int ans = start^goal;// this makes all the different bits one and same bits zero
		
		while(ans>0) {
			ans = ans&(ans-1);
			count++;
		}
		
		
		return count;
	}
	public static void main(String[] args) {
		int start = 10;
		int goal = 7;
		
		int count  = getMinBitFlips(start,goal);
		
		System.out.println("Th minimum bit flips to attain the goal is:"+count);
	}

}
