package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class CountReversePair {
	public static int merge(int[] arr, int low, int mid, int high) {
		int count=0;
		List<Integer> mergeArr = new ArrayList<>();			
		int left = low;
		int right = mid+1;
		while(left<=mid) {
			while(right<=high && arr[left]>2*arr[right]) {
				right++;
			}
			count+=(right-(mid+1));
			left++;

		}
		left = low;
		right = mid+1;
		while(left<=mid && right<=high) {
			if(arr[left]>arr[right]) {
				mergeArr.add(arr[right]);
				right++;
			}else {
				mergeArr.add(arr[left]);
				left++;
			}
		}
		
		while(left<=mid) {
			mergeArr.add(arr[left]);
			left++;
		}
		while(right<=high) {
			mergeArr.add(arr[right]);
			right++;
		}
		for(int i=low;i<=high;i++) {
			arr[i] = mergeArr.get(i-low);
		}
		
		return count;
	}
	public static int mergeSort(int[] arr,int low,int high) {
		int count=0;
		int mid = (high+low)/2;
		if(low>=high) return count;
		count+=mergeSort(arr,low,mid);
		count+=mergeSort(arr,mid+1,high);
		count+=merge(arr,low,mid,high);
		
		return count;
	}
	public static int reversePairsOpt(int[] arr) {
		int count = mergeSort(arr,0,arr.length-1);
		return count;
	}

	public static int reversePairsBrut(int[] arr) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>2*arr[j])
					count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,3,5,1};
		
		int count1 = reversePairsBrut(arr);
		int count2 = reversePairsOpt(arr);
		System.out.println("The number of reverse pairs for the array is:"+count1);
		System.out.println("The number of reverse pairs for the array is:"+count2);
	}
}
