package G.Sorting;

import java.util.Arrays;

/***
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
    Start at the beginning of the list.
    Compare each pair of adjacent elements.
    If the elements are in the wrong order, swap them.
    Move to the next pair and repeat step 3 until the end of the list.
    After each pass through the list, the largest element moves to its correct position.
    Repeat the process for the remaining elements (excluding the last sorted elements) until no swaps are needed.
Time Complexity: O(n^2)
Auxiliary space complexity: O(1)

 ***/

public class BubbleSort {
	
	public static int[] bubbleSort(int[] arr) {
		
		int n = arr.length;
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<n-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
		return arr;
	}	
	public static int[] bubbleSort2(int[] arr) {
		
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		
		return arr;
	}	
	
	
	public static void bubbleSortRec(int[] arr,int i) {		
		int n = arr.length;
		System.out.println("i:"+i);
		if(i>=n) return;
		
		for(int j=0; j<n-1;j++) {
			System.out.println("j"+j);
			if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			System.out.println("hi1");
			}
		System.out.println("hi3");

			bubbleSortRec(arr,i+1);
	}	
	
	public static void main(String[] args) {
		int arr[] = {13,46,24,52,20,9};
		
		int[] sortedArr = bubbleSort2(arr);
		System.out.println(Arrays.toString(sortedArr));
		
		int arr2[] = {13,46,24,52,20,9};
		bubbleSortRec(arr2,0);
		System.out.println(Arrays.toString(arr2));
		
	}

}
