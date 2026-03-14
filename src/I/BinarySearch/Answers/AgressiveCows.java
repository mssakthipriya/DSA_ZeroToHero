package I.BinarySearch.Answers;

import java.util.Arrays;

public class AgressiveCows {
	public static boolean getDistCheck(int[] stalls, int dist, int k) {
		int count  =1;
		int last = stalls[0];
		for(int i=1;i<stalls.length;i++) {
			if((stalls[i]-last)>=dist) {
				count++;
				last=stalls[i];
			}
			if(count>=k)
				return true;
		}
		
		
		return false;
	}
	public static int getMinDistance(int[] stalls, int k) {
		Arrays.sort(stalls);
		int low = 1;
		int high = stalls[stalls.length-1]-stalls[0];
		
		while(low<=high) {
			int mid = (low+high)/2;
			boolean check = getDistCheck(stalls,mid,k);
			if(check) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		
		
		
		return high;
	}
	
	public static void main(String[] args) {
		int[] stalls = {0,3,4,7,10,9};
		int k = 4;
		int min = getMinDistance(stalls,k);
		
		System.out.println("The minimum distance to keep the aggressive cows is:"+min);
	}

}
