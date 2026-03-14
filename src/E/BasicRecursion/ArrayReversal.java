package E.BasicRecursion;

import java.util.Arrays;

public class ArrayReversal {
	
	public static int[] reverseArrayUtil(int[] arr,int first,int last) {
		if(first>=last)
			return arr;
		int temp=arr[first];
		arr[first]=arr[last];
		arr[last]= temp;
		
		return reverseArrayUtil(arr,first+1,last-1);
	}
	
	public static int[] reverseArray(int[] arr) {
		return reverseArrayUtil(arr,0,arr.length-1);
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		int last = arr.length-1;
		//int[] revArr = reverseArray(arr, 0, last);
		int[] revArr = reverseArray(arr);
		System.out.println(Arrays.toString(revArr));
	}

}
