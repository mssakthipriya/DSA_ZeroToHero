package I.BinarySearch.Answers;

public class KokosBananaCraze {
	public static int getMax(int[] piles) {
		int max=0;
		
		for(int i=0;i<piles.length;i++) {
			max = Math.max(max, piles[i]);
		}
		
		return max;
	}
	public static int getHoursPerPile(int[] piles, int bph) {
		int hours=0;
		for(int i=0;i<piles.length;i++) {
		 hours+= Math.ceil((double)piles[i]/(double)bph);
		}	
		
		return hours;
	}
	
	public static int getMaxBPH(int[] piles,int hours) {
		int low=1;
		int high = getMax(piles);
		
		while(low<=high) {
			int mid = (low+high)/2;
			int midHrs = getHoursPerPile(piles,mid);
			if(midHrs==hours) {
				return mid;
			}else if(midHrs>hours) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] piles = {7, 15, 6, 3};
		int hours = 8;
		int maxBPH = getMaxBPH(piles,hours);
		System.out.println("If koko eats atmost "+maxBPH+" bananas per hour, then he can finish by "+hours+" hours!");
	}

}
