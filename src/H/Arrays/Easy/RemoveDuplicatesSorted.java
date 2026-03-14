package H.Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesSorted {
	
	public static int[] removeDuplicates(int[] arr) {
		ArrayList<Integer> arrList = new ArrayList<>();	
		arrList.add(arr[0]);
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]!=arr[i]) {
				arrList.add(arr[i]);
			}
		}
		Arrays.fill(arr, 0);
		for(int i=0;i<arrList.size();i++) {
			arr[i] = arrList.get(i);
		}
		return arr;
	}
	
	public static int[] removeDuplicatesOpt(int[] arr) {
		int j = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=arr[j]) {
				arr[j+1] = arr[i];
				j++;
			}
		}
		for(int k = j+1; k <arr.length;k++) {
			arr[k] = 0;
		}

		return arr;
	}
	
	public static void main(String[] args) {

		int[] arr = {1,1,1,2,2,3,3,3,3,4,4};
		
		int [] sortedArr = removeDuplicates(arr);
		
		System.out.println(Arrays.toString(sortedArr));
		
		int[] arr2 = {1,1,1,2,2,3,3,3,3,4,4};
		int [] sortedOptArr = removeDuplicatesOpt(arr2);
		System.out.println(Arrays.toString(sortedOptArr));

	}
	


}
