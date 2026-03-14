package H.Arrays.Easy;

import java.util.Arrays;

public class LargestNumber {
	
	public static int getLargestNum(int[] arr) {
		int x = arr[0];
		
		for(int i =0;i<arr.length;i++) {
			if(x<arr[i])
				x = arr[i];
		}
		
		return x;
	}
	
	public static int getLargestNum2(int[] arr) {

		Arrays.sort(arr);
		
		return arr[arr.length-1];
	}
	
	public static void main(String[] args) {
		int arr[] = {2,5,1,3,0};
		
		System.out.println("The largest number is : "+getLargestNum(arr));
		System.out.println("The largest number is : "+getLargestNum2(arr));
	}

}
