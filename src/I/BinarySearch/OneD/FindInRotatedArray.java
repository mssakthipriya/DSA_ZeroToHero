package I.BinarySearch.OneD;

public class FindInRotatedArray {
	
	public static int findInRotated(int[] arr, int x) {
		int index = -1;
		int i=0, j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]==x) {
				index=mid;
			}
			if(arr[i]<=arr[mid]) {
				if(arr[i]<=x && x<arr[mid]) {
					j=mid-1;
				}else {
					i = mid+1;
				}
			}else {
				if(x>=arr[mid] && x <=arr[j]) {
					i=mid+1;
				}else {
					j=mid-1;
				}
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2,3};
		int k = 0;
		
		int index = findInRotated(arr,k);
		System.out.println("The number "+k+" is found in index:"+index);
		
	} 

}
