package I.BinarySearch.OneD;

public class SearchIndexPosition {

	public static int getIndexPosition(int[] arr, int num) {
		int index = arr.length;
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]>=num) {
				index = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		return index;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,7};
		int num = 6;
		
		int index = getIndexPosition(arr,num);
		System.out.println("The index position for "+num+" is:"+index);
	}
}
