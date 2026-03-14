package P.Heaps;

public class MaxHeapChecker {
	public static boolean checkMinHeap(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int parent = (i-1)/2;
			if(arr[parent]<arr[i])
				return false;
		}
		
		return true;
	}
	
	public static boolean checkMinHeapII(int[] arr) {
	    for (int i = 0; i <= (arr.length - 2)/2; i++) {
	        int left = 2*i + 1;
	        int right = 2*i + 2;

	        if (left < arr.length && arr[i] < arr[left])
	            return false;
	        if (right < arr.length && arr[i] < arr[right])
	            return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		//int[] arr = {5, 10, 15, 30, 20, 50, 40};
		int[] arr = {90, 15, 10, 7, 12, 2};
		
		System.out.println(checkMinHeap(arr));
	}

}
