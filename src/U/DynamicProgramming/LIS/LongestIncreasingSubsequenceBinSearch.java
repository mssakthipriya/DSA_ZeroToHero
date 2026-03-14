package U.DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequenceBinSearch {
	
	public static int getLongestIncreasingSub(int[] arr) {
		List<Integer> subList = new ArrayList<>();
		subList.add(arr[0]);
		for(int i=1;i<arr.length;i++) {			
			if(arr[i]>subList.get(subList.size()-1)) {
				subList.add(arr[i]);
			}else {
				int index = Collections.binarySearch(subList, arr[i]);
				//System.out.println(index);
				if(index<0) index = -(index+1);
				subList.set(index, arr[i]);
			}
		}
		
		return subList.size();		
	}
	public static void main(String[] args) {
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		
		int longestSubLength = getLongestIncreasingSub(arr);
		
		System.out.println(longestSubLength);
	}

}
