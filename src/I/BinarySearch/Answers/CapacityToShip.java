package I.BinarySearch.Answers;

public class CapacityToShip {

	public static int getDay(int[] arr,int weigh) {
		int count = 1;
		int w = 0;
		for(int i=0;i<arr.length;i++) {
			w+=arr[i];
			if(w>weigh) {
				w=arr[i];
				count++;
			}
		}
		return count;
	}
	public static int getLeastWeightCapacity(int[] weights, int days) {
		int low = 0;
		int high = 0;
		for(int i=0;i<weights.length;i++) {
			low = Math.max(low, weights[i]);
			high +=weights[i];
		}
		while(low<=high) {
			int mid = (low+high)/2;
			int day = getDay(weights,mid);
			if(day<=days) {
				high=mid-1;
			}else {
				low = mid+1;
			}
		}
		
		
		return low;
	}
	public static void main(String[] args) {
		int[] arr = {5,4,5,2,3,4,5,6};
		int d = 5;
		int weigh = getLeastWeightCapacity(arr,d);
		System.out.println("For the shipment to be completed in "+d+" days, the least weight capacity is:"+weigh);
	}

}
