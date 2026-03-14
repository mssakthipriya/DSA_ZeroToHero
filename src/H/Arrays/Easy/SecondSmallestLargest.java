package H.Arrays.Easy;

import java.util.Arrays;

public class SecondSmallestLargest {
	
	public static void getSecSmallestLargest(int[] arr) {
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length-1;
		while(arr[i]==arr[i+1]) {
			i++;
		}
		while(arr[j]==arr[j-1]) {
			j--;
		}
		
		System.out.println("The second Smallest element is:"+arr[i+1]+", The second largest element is:"+arr[j-1]);
		
	}
	
	public static void getSecSmallestLargest2(int[] arr) {
		
		int largest = Integer.MIN_VALUE;
		int secLargest = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		int secSmallest = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]> largest) {
				secLargest = largest;
				largest = arr[i];
			}else if(arr[i]>secLargest && arr[i]!=largest) {
				secLargest = arr[i];
			}
			if(arr[i]<smallest) {
				secSmallest = smallest;
				smallest = arr[i];
			}else if(arr[i]<secSmallest && arr[i]!=smallest) {
				secSmallest = arr[i];
			}
		}
		
		System.out.println("The second Smallest: "+secSmallest+": the second largest:"+ secLargest);
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,4,7,7,5};
		getSecSmallestLargest(arr);
		int[] arr2 = {7,1,2,4,7,5};
		getSecSmallestLargest2(arr2);
		
	}

}
