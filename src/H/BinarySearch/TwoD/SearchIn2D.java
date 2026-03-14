package H.BinarySearch.TwoD;

public class SearchIn2D {

	public static boolean search2D(int[][] arr, int target) {
		int n=arr.length;
		int m=arr[0].length;
		int low = 0;
		int high = (n*m)-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			int r=mid/m;
			int c=mid%m;
			if(arr[r][c]==target) return true;
			else if(arr[r][c]>target) high=mid-1;
			else low=mid+1;
		}
		
		
		
		return false;
	}
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int target = 8;
		boolean present = search2D(arr,target);
		if(present) {
			System.out.println("The target "+target+" is present in Array :D");
		}else {
			System.out.println("The target "+target+" is not present in Array :(");
		}
	}
}
