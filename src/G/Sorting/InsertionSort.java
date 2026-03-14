package G.Sorting;

import java.util.Arrays;

/***
Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its
correct position in a sorted portion of the list.

    We start with the second element of the array as the first element is assumed to be sorted.
    Compare the second element with the first element if the second element is smaller then swap them.
    Move to the third element, compare it with the first two elements, and put it in its correct position
    Repeat until the entire array is sorted.
    Time Complexity: O(n^2)
	Auxiliary space complexity: O(1)

***/

public class InsertionSort {
	
	public static int[] insertionSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i=0; i<n;i++) {
			int j = i;
			while(j>0 && arr[j-1]>arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j--;
			}
			System.out.println(Arrays.toString(arr));
			
		}
		return arr;
	}
		
		public static void insertionSortRec(int[] arr, int i) {
			
			int n = arr.length;
			if(i>=n) return;

				int j = i;
				while(j>0 && arr[j-1]>arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					j--;
				}
				//System.out.println("Recursion:"+Arrays.toString(arr));

				insertionSortRec(arr, i+1);
	}
	
	public static void main(String[] args) {
		int[] arr = {13,46,24,52,20,9};
		
		int[] sortedArr = insertionSort(arr);
		System.out.println(Arrays.toString(sortedArr));
		
		int[] arr2 = {13,46,24,52,20,9};
		insertionSortRec(arr2, 0);
		
		System.out.println("Recursion:"+Arrays.toString(arr2));
		
	}

}
