package H.BinarySearch.TwoD;

import java.util.Arrays;

public class TwoDPeak {
	public static int getHighestPoint(int[][] mat,int mid) {
		int max=-1;
		int index = -1;
		for(int i=0;i<mat.length;i++) {
			if(max<mat[i][mid]){
				max = mat[i][mid];
				index = i;
			}
		}
		
		return index;
	}
	public static int[] findPeakGrid(int[][] mat) {
		int[] coordinates = {-1,-1};
		int low = 0;
		int m = mat[0].length;
		int high = m-1;
		while(low<=high) {
			int mid = (low+high)/2;
			int ind = getHighestPoint(mat,mid);
			int left = mid-1>=0?mat[ind][mid-1]:-1;
			int right = mid+1<m?mat[ind][mid+1]:-1;
			if(left<mat[ind][mid] && right<mat[ind][mid]) {
				coordinates[0]=ind;
				coordinates[1]=mid;
				return coordinates;
			}else if(mat[ind][mid-1]>mat[ind][mid]) high = mid-1;
			else low=mid+1;
		}
		
		return coordinates;		
	}
	public static void main(String[] args) {
		int[][] arr = {{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
		int[] peakCoordinates = findPeakGrid(arr);
		System.out.println("The peak coordinates are:"+Arrays.toString(peakCoordinates));
	}

}
