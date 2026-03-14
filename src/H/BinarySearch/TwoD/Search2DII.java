package H.BinarySearch.TwoD;

public class Search2DII {
	
	public static boolean checkTarget(int[][] arr, int target) {
		
		int n = arr.length;
		int m = arr[0].length;
		int row=0;
		int col = m-1;
		
		while(row<n && col>=0) {
			if(arr[row][col]==target) return true;
			else if(arr[row][col]<target) row++;
			else col--;
		}
		
		
		
		return false;
	} 
	
	public static void main(String[] args) {
		int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 21;
		
		boolean found = checkTarget(arr,target);
		
		if(found) {
			System.out.println("The target is present int he array :)");
		}else {
			System.out.println("The target is not present in the array :(");
		}
	}

}
