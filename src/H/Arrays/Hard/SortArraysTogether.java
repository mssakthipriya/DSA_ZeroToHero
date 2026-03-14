package H.Arrays.Hard;

import java.util.Arrays;

public class SortArraysTogether {
	//gap method derived from shell sort
	public static void sortArraysOptII(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int len = n+m;
		int gap = (len/2)+(len%2);
		while(gap>0) {
			int i=0;
			int j=i+gap;
			while(j<len) {
				if(i<n && j>=n) {
					swap(arr1,arr2,i,j-n);
				}else if(i>=n) {
					swap(arr2,arr2,i-n,j-n);
				}else {
					swap(arr1, arr1, i, j);
				}
				i++;
				j++;
			}
			if(gap==1) break;
			gap = (gap/2)+(gap%2);
		}
		
	}
	
	public static void swap(int[] arr1, int[] arr2,int ind1,int ind2) {
		if(arr1[ind1]>arr2[ind2]) {
			int temp =arr1[ind1];
			arr1[ind1] = arr2[ind2];
			arr2[ind2] = temp;
		}
	}
	
	// Time complexity = O(min(m,n))+O(nlogn)_O(nlogm)
	public static void sortArraysOptI(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int i=n-1, j=0;
		while(i>=0 && j<m) {
			if(arr1[i]>arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i--;
				j++;
			}else {
				break;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
	public static void sortArrays(int[] arr1, int[] arr2) {
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]>arr2[0]) {
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				Arrays.sort(arr2);
			}
		}
	}

	public static void main(String[] args) {
		//int[] arr1 = {1,3,5,7};
		//int[] arr2 = {0,2,6,8,9};
		int[] arr1={1, 4, 8, 10};
        int[] arr2={2,3,9};
		sortArraysOptII(arr1,arr2);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}
}
