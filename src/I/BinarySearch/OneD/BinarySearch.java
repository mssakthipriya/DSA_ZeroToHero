package I.BinarySearch.OneD;
/***
 Binary Search Algorithm is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
 The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(log N).
 steps:
    Divide the search space into two halves by finding the middle index "mid". 
    Compare the middle element of the search space with the key. 
    If the key is found at middle element, the process is terminated.
    If the key is not found at middle element, choose which half will be used as the next search space.
        If the key is smaller than the middle element, then the left side is used for next search.
        If the key is larger than the middle element, then the right side is used for next search.
    This process is continued until the key is found or the total search space is exhausted.
***/
public class BinarySearch {

	public static int binarySearchItr(int[] arr, int num) {
		int index = -1;
		int i = 0;
		int j = arr.length-1;
		
		while(i<=j) {
			int mid = (i+j)/2;
			System.out.println("mid:"+mid);
			if(arr[mid]==num) {
				index = mid;
				break;
			}else if(num<arr[mid]) {
				j=mid-1;
			}else {
				i=mid+1;
			}
		}
		
		
		return index;
	}
	
	public static int binarySearchRec(int[] arr, int num) {
		int index = -1;
		int begin = 0;
		int end = arr.length-1;
		index = recSearch(arr, num, begin,end);
		
		return index;
	}
	
	public static int recSearch(int[] arr, int num, int begin,int end) {
		if(begin>end) {
			return -1;
		}
		int mid = (begin+end)/2;
		if(arr[mid]==num) {
			return mid;
		}else if(num<arr[mid]) {
			return recSearch(arr, num, begin,mid-1);
		}else {
			return recSearch(arr, num, mid+1,end);
		}

	}
	public static void main(String[] args) {
		int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
		int num = 6;
		
		int index = binarySearchItr(arr, num);
		System.out.println("The index of "+num+" in the array is:"+index);
		
		int index2 = binarySearchRec(arr, num);
		System.out.println("The index of "+num+" in the array vis recursion is:"+index2);
	}
}
