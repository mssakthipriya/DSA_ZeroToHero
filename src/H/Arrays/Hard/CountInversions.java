package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
	
	public static int merge(int[] arr,int low, int mid, int high) {
		List<Integer> sortList = new ArrayList<>();
		int count=0;
		int left = low;
		int right = mid+1;
		
		while(left<=mid && right<=high) {
			if(arr[left]>arr[right]) {
				count+=(mid-left)+1;
				sortList.add(arr[right]);
				right++;
			}else {
				sortList.add(arr[left]);
				left++;
			}
		}
		while (left<=mid) {
			sortList.add(arr[left]);	
			left++;
		}
		while(right<=high) {
			sortList.add(arr[right]);
			right++;
		}
		
		for(int i=low;i<=high;i++) {
			arr[i] = sortList.get(i-low);
		}
		
		
		return count;
	}
	
	public static int mergeSort(int[] arr,int low,int high) {
		int count = 0;
		if(low>=high) return count;
		int mid = (low+high)/2;
		count+=mergeSort(arr,low,mid);
		count+=mergeSort(arr,mid+1,high);
		count+=merge(arr,low,mid,high);
		
		
		return count;
	}
	
	//Time Complexity: O(N*logN)
	//Space Complexity: O(N)
	public static int countInversionsOpt(int[] arr) {
		
		int count  = mergeSort(arr,0,arr.length-1);		
		
		return count;
	}

	public static int countInversionsBrut(int[] arr) {
		int count  = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j])
					count++;
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		int[] arr = {5,3,2,1,4};
		
		int count1 = countInversionsBrut(arr);
		int count2 = countInversionsOpt(arr);
		System.out.println("The number of inversions in this array is:"+count1);
		System.out.println("The number of inversions in this array is:"+count2);
	}
}
