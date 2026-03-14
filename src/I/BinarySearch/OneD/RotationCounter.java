package I.BinarySearch.OneD;
//anticlockwise
public class RotationCounter {
	public static int rotationCounter(int[] arr) {
		int counter = 0;
		int index=0;
		int i=0,j=arr.length-1;
		int min=arr[0];
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[i]<=arr[mid]) {
				if(arr[i]<min) {
				min=  arr[i];
				index = i;
				}
				i=mid+1;
			}else {
				if(arr[mid]<min) {
				min = arr[mid];
				index = mid;
				}
				j=mid-1;
			}
		}
		System.out.println("index:"+index);
		counter = arr.length-index;
		return counter;
	}
	public static void main(String[] args) {
		int arr[] = {3,4,5,1,2};
		int counter = rotationCounter(arr);
		
		System.out.println("The array has been rotated anticlock wise:"+counter+" times");
	}
}
