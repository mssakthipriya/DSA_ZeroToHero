package I.BinarySearch.OneD;

public class MinimumInRotated {

	public static int getMinimum(int[] arr) {
		int min = arr[0];
		int i=0;
		int j=arr.length-1;
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[i]<=arr[mid]) {
				min = Math.min(min, arr[i]);
				i=mid+1;
			}else {
				min = Math.min(min, arr[mid]);
				j=mid-1;
			}
		}
		
		return min;
	}
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2,3};
		int min = getMinimum(arr);
		
		System.out.println("The minimum value in the rotated array is:"+min);
	}
}
