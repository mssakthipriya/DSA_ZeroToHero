package I.BinarySearch.OneD;

public class FindInRotatedArrayII {
	
	public static boolean findInRotated(int[] arr, int x) {
		int index = -1;
		int i=0, j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			if(arr[mid]==x) {
				return true;
			}
			if(arr[i]==arr[mid] && arr[mid]==arr[j]) {
				i=i+1;
				j=j-1;
				continue;
			}
			if(arr[i]<=arr[mid]) {
				if(arr[i]<=x && x<=arr[mid]) {
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
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,5,0,2,2,2,2,2,2};
		int k = 0;
		
		boolean flag = findInRotated(arr,k);
		System.out.println("The number "+k+" is found in index:"+flag);
		
	} 

}
