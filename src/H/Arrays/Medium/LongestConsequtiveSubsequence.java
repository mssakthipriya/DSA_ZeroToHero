package H.Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSubsequence {
	
	public static int longestSubII(int[] arr){
		Set<Integer> sub = new HashSet<>();
		int count = 1;
		int max = 0;
		for(int e:arr) {
			sub.add(e);
		}
		for(int i:arr) {
			if(sub.contains(i+1)) {
				count++;
			}else {
				count=1;
			};
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	public static int longestSub(int[] arr){
		Arrays.sort(arr);
		int count = 1;
		int max = 0;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1]==arr[i]-1) {
				count++;
			}else {				
				count=1;
			}
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 8, 5, 7, 6};
		System.out.println("The longest consecutive sub is:"+longestSub(arr));
		int[] arr2 = {3, 8, 5, 7, 6};
		System.out.println("The longest consecutive sub is:"+longestSubII(arr2));
	}

}
