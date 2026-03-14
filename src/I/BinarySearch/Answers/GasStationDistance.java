package I.BinarySearch.Answers;

public class GasStationDistance {
	public static int getNumberOfStations(int[] points, double mid) {
		int count=0;
		for(int i=1;i<points.length;i++) {
			int numInBtw = (int) ((points[i]-points[i-1])/mid);
			if((points[i]-points[i-1])/mid==numInBtw) {
				numInBtw--;
			}
			count+=numInBtw;
		}
		return count;
	}
	public static double getMaxDist(int[] points, int k) {
		double low = 0;
		double high=0;
		for(int i=0;i<points.length-1;i++) {
			high = Math.max(high, (double)points[i+1]-points[i]);
		}
		double diff = 1e-6 ;
		while(high-low>diff) {
			double mid = (high+low)/2;
			int cnt = getNumberOfStations(points,mid);
			if(cnt<=k) {
				high=mid;
			}else {
				low=mid;
			}
		}
		
		return high;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 4;
		
		double maxDist = getMaxDist(arr,k);
		System.out.println("The maximum distance after adding the gas stations are:"+maxDist);
	}

}
