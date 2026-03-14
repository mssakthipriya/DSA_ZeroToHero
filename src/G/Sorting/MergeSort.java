package G.Sorting;

/***
Divide: Divide the list or array recursively into two halves until it can no more be divided. 
Conquer:Each subarray is sorted individually using the merge sort algorithm. 
Merge:  The sorted subarrays are merged back together in sorted order.
        The process continues until all elements from both subarrays have been merged. 
***/

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	
	public static int[] mergeSort(int[] arr) {

		int low = 0;
		int high = arr.length-1;
		divide(arr,low,high);		
		
		return arr;
	}
	
	public static void divide(int[] arr, int low, int high) {
		if(low==high) return;
		
		int mid = (low+high)/2;
		
		divide(arr,low,mid);
		divide(arr,mid+1,high);
		merge(arr,low,mid,high);
		
	}
	
	public static void merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> arrList = new ArrayList<>();
		int left = low;
		int right = mid+1;
		while(left<=mid && right<=high) {
			if(arr[left]<=arr[right]) {
				arrList.add(arr[left]);
				left++;
			}else {
				arrList.add(arr[right]);
				right++;
			}
			
		}
		
		while(left<=mid) {
			arrList.add(arr[left]);
			left++;
		}
		
		while(right<=high) {
			arrList.add(arr[right]);
			right++;
		}
		
		for(int i=low;i<=high;i++) {
			arr[i] = arrList.get(i-low);
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,8,5,1,4,23};
		
		int[] sortedArr = mergeSort(arr);
		
		System.out.println(Arrays.toString(sortedArr));
	}

}
