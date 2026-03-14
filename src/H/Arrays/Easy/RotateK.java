package H.Arrays.Easy;

import java.util.Arrays;

public class RotateK {
	
	public static int[] rotateRightK(int[] arr, int k) {
		reverseArr(arr, 0, arr.length-1);
		reverseArr(arr, 0, k-1);
		reverseArr(arr, k, arr.length-1);
		return arr;
	}
	
	public static void reverseArr(int[] arr, int first, int last) {
		while(first<last) {
			int temp = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;
			first++;
			last--;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,7,8,9,10,11};
		int k = 2;
		
		int[]rotatedArr = rotateRightK(arr, k);
		
		System.out.println(Arrays.toString(rotatedArr));
	}

}
