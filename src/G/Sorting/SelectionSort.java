package G.Sorting;

import java.util.Arrays;

/***
 Selection Sort is a comparison-based sorting algorithm.
    First we find the smallest element and swap it with the first element.
    This way we get the smallest element at its correct position.
    Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
    We keep doing this until we get all elements moved to correct position.
 Time complexity: O(n^2)
 Auxiliary space complexity: O(1);
 ***/

public class SelectionSort {
	
	public static int[] selectionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=0;i<n;i++) {
			int min = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
			System.out.println(Arrays.toString(arr));
		}
		
		
		return arr;
	}
	
	
public static void main(String[] args) {
	
	int[] arr = {13,46,24,52,20,9};
	
	int[] sortedArr = selectionSort(arr);
	
	System.out.println(Arrays.toString(sortedArr));
	
}
}
