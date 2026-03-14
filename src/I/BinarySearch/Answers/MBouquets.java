package I.BinarySearch.Answers;

public class MBouquets {
	public static boolean checkDays(int[] blooms,int day,int m,int k) {
		int count=0;
		int noBK = 0;
		for(int i=0;i<blooms.length;i++) {
			if(blooms[i]<day) {
				count++;
			}else {
				noBK+=count/k;
				count=0;
			}
		}
		noBK+=count/k;
		return noBK>=m;
	}
	public static int getMinBloomDays(int[] blooms,int m, int k) {
		int low = Integer.MAX_VALUE;
		int high = 0;	
		int val = m*k;
		if(val>blooms.length) return -1;
		for(int i=0;i<blooms.length;i++) {
			low = Math.min(low, blooms[i]);
			high = Math.max(high, blooms[i]);
		}
		
		while(low<=high) {
			int mid = (low+high)/2;
			boolean days = checkDays(blooms,mid,m,k);
			if(days) {
				high=mid-1;
			}else {
				low = mid+1;
			}
		}
		
		
		return low;
	}

	public static void main(String[] args) {
		int[] blooms = {1, 10, 3, 10, 2};
		int m = 3, k = 2;
		
		int days = getMinBloomDays(blooms,m,k);
		
		System.out.println("The minimum number of days taken to make "+m+" bouquets is:"+days);
	}
}
