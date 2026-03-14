package H.Arrays.Easy;

import java.util.Arrays;

public class MoveZeros {

	public static int[] zeroMover(int[] arr) {
		int j = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[j]!=0) {				
				j++;
			}
			if(arr[i]!=0 && j<i) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp; 
			}

		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
		
		int[] sortedArr = zeroMover(arr);
		
		System.out.println(Arrays.toString(sortedArr));
	}
}
