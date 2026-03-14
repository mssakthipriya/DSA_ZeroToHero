package I.BinarySearch.OneD;

public class UpperBound {

	public static int getUpperBound(int[] arr,int num) {
		int index = arr.length;
		int i=0, j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]>num) {
				index=mid;
				j=mid-1;
			}else {
				i=mid+1;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,5,8,9,15,19};
		int num = 9;
		
		int upperBound = getUpperBound(arr, num);
		
		System.out.println("The upper bound of the array with respect to the "+num +" is:"+upperBound);
	}
}
