package G.Sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static int[] quickSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		qSort(arr,low,high);
		
		return arr;
	}
	
	public static void qSort(int[] arr, int low, int high) {
		if(low<high) {
			int pivotPos = partition(arr,low,high);
			qSort(arr,low,pivotPos-1);
			qSort(arr,pivotPos+1,high);
		}
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		while(i<j) {
			while(arr[i]<= pivot && i<high) {
				i++;
			}
			while(arr[j]>pivot && j>low){
				j--;
			}
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		

			int temp = arr[j];
			arr[j] = arr[low];
			arr[low] = temp;

		
		return j;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {4,6,2,5,7,9,1,3};
		
		int[] sortedArr = quickSort(arr);
		
		System.out.println(Arrays.toString(sortedArr));
		
	}

}
