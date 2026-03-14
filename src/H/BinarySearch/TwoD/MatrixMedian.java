package H.BinarySearch.TwoD;

public class MatrixMedian {
	public static int upperBound(int[] arr, int x) {
		int n = arr.length;
		int ans=n;
		int low = 0;
		int high = n-1;
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(arr[mid]>x) {
				ans = mid;
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		
		
		return ans;
	}
	public static int countSmallEqual(int[][] arr,int x) {
		int count = 0;
		int m = arr.length;
		for(int i=0;i<m;i++) {
			count+=upperBound(arr[i],x);
		}
		return count;
	}
	public static int getMedian(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int low=Integer.MAX_VALUE;
		int high=Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			low=Math.min(low, arr[i][0]);
			high=Math.max(high, arr[i][n-1]);
		}

		int req = (n*m)/2;
		System.out.println("low:"+low+",high:"+high+",req"+req);
		
		while(low<=high) {
			int mid = (low+high)/2;
			int smallEqual = countSmallEqual(arr,mid);
			System.out.println("mid:"+mid+", smallEqual:"+smallEqual);
			if(smallEqual<=req) low=mid+1;
			else high = mid-1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,4,9},{2,5,6},{3,7,8}};
		
		int median = getMedian(arr);
		
		System.out.println("The median of the matrix is:"+median);
	}

}
