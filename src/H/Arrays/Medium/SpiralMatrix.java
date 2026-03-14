package H.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix {
	public static ArrayList<Integer> spiral(int[][] arr) {
		ArrayList<Integer> arrList = new ArrayList<>();
		int m = arr.length;//number of rows
		int n = arr[0].length;//number of columns
		int colBegin = 0;
		int colEnd = n-1;
		int rowBegin = 0;
		int rowEnd = m-1;
		
		while(colBegin<=colEnd && rowBegin<=rowEnd) {
			for(int i = colBegin;i<=colEnd;i++) {
				arrList.add(arr[rowBegin][i]);
			}
			rowBegin++;
			for(int i = rowBegin;i<=rowEnd;i++) {
				arrList.add(arr[i][colEnd]);
			}
			colEnd--;
			for(int i = colEnd;i>=colBegin;i--) {
				arrList.add(arr[rowEnd][i]);
			}
			rowEnd--;
			for(int i = rowEnd;i>=rowBegin;i--) {
				arrList.add(arr[i][colBegin]);
			}
			colBegin++;
		}
		
		return arrList;
	}

	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> arrList = spiral(arr);

		System.out.println(arrList.toString());

	}
}
