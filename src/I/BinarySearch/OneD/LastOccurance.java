package I.BinarySearch.OneD;

public class LastOccurance {

	public static int lastOccurance(int[] arr, int num) {
		int index = arr.length;
		int i = 0,j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]==num) {
				index = mid;
				i=mid+1;
			}else if(arr[mid]>num) {
				j=mid-1;
			}else {
				i=mid+1;
			}
		}

		
		return index;
	}
	
	public static int firstOccurance(int[] arr, int num) {
		int index = arr.length;
		int i = 0,j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]==num) {
				index = mid;
				j=mid-1;
			}else if(arr[mid]>num) {
				j=mid-1;
			}else {
				i=mid+1;
			}
		}

		
		return index;
	}
	public static void main(String[] args) {
		int[] arr= {3,4,13,13,13,20,40};
		int x = 13;
		int index1 = lastOccurance(arr,x);
		System.out.println("The last occurance of "+x+" is:"+index1);
		
		int index2 = firstOccurance(arr,x);
		System.out.println("The first occurance of "+x+" is:"+index2);
	}
}
