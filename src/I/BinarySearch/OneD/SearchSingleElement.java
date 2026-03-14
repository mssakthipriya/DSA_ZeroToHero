package I.BinarySearch.OneD;

public class SearchSingleElement {
	public static int getSingleElement(int[] arr) {
		int i=1,j=arr.length-2;
		if(arr[0]!=arr[1]) return arr[0];
		if(arr[arr.length-1]!=arr[arr.length-2]) return arr[arr.length-1];
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]!=arr[mid+1]&& arr[mid]!=arr[mid-1]) {
				return arr[mid];				
			}else if((arr[mid]==arr[mid-1] && mid%2!=0)||(arr[mid]==arr[mid+1] && mid%2!=1)) {
				i=mid+1;
			}else {
				j=mid-1;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
		
		int loner = getSingleElement(arr);
		System.out.println("The loner in the array is:"+loner);
		
	}
}
