package H.BinarySearch.TwoD;

public class RowMaxOnes {
	public static int getEnd(int[][] arr, int i) {
		int c = arr.length;
		int low = 0;
		int high = c-1;
		int ans = c;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[i][mid]==1) {
				ans =mid;
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return ans;
	}
	public static int getMaxOneRow(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int index = -1;
		int max = 0;
		for(int i=0;i<r;i++) {
			//System.out.println("c:"+c+"; getEnd(arr,i):"+getEnd(arr,i));
			int count = c-getEnd(arr,i);

			if(max<count) {
				max = count;
				index = i;
			}
		}
		
		
		return index;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{0,1,1},{0,0,1},{1,1,1}};
		
		
		int max = getMaxOneRow(arr);
		System.out.println("The row with maximum one's in the matrix is:"+max);
	}

}
