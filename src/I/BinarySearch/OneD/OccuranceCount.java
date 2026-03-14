package I.BinarySearch.OneD;

public class OccuranceCount {
	
	public static int countOccurance(int[] arr,int num) {
		int start = -1;
		int end = -1;
		int i=0,j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			
			if(arr[mid]==num) {
				start=mid;
				j=mid-1;
			}else if(arr[mid]<num) {
				i=mid+1;
			}else {
				j=mid-1;
			}
			
			
		}
		i=0;j=arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			
			if(arr[mid]==num) {
				end=mid;
				i=mid+1;
			}else if(arr[mid]<num) {
				i=mid+1;
			}else {
				j=mid-1;
			}
			
			
		}
		System.out.println("start:"+start+":end:"+end);
		
		if(end==-1)
			return 0;
		
		return (end-start)+1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 2, 2, 2, 3};
		int x = 2;
		
		int count = countOccurance(arr,x);
		System.out.println("The count of "+x+" in the array is:"+count);
	}

}
