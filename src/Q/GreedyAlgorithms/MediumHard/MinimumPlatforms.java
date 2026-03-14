package Q.GreedyAlgorithms.MediumHard;

import java.util.Arrays;

public class MinimumPlatforms {
	public static int countPlatforms(int[] arr, int[] dep) {
		int n = arr.length;
		int minPlatforms = 0;
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int platforms = 1;
		int i=1; int j =0;
		
		while(i<n && j<n) {
			if(arr[i]<=dep[j]) {
				platforms++;
				i++;
			}else {
				platforms--;
				j++;
			}
			minPlatforms = Math.max(minPlatforms, platforms);
		}
		
				
				
				
		return minPlatforms;
	}
	public static void main(String[] args) {
		int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        
        int minPlatforms = countPlatforms(arr, dep);
        
        System.out.println(minPlatforms);
	}

}
