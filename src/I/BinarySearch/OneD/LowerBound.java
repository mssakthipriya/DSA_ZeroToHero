package I.BinarySearch.OneD;

public class LowerBound {

	public static int getLowerBound(int[] arr, int num) {
		int low = arr.length;
		int i=0;
		int j = arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]>=num) {
				low = mid;
				j=mid-1;
			}else {
				i=mid+1;
			}
		}
		
		return low;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,3};
		int num = 2;
		
		int lowerBound = getLowerBound(arr, num);
		
		System.out.println("The lower bound of the array with respect to the "+num +" is:"+lowerBound);
	}
}
