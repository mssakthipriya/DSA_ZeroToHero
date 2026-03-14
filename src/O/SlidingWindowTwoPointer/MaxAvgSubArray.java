package O.SlidingWindowTwoPointer;

public class MaxAvgSubArray {

	public static double getMaxAvgSum(int[] arr,int k) {
		int sum = 0;
		for(int i=0;i<k;i++) {
			sum+=arr[i];
		}
		int max = sum;
		int start =0;
		int end=k;
		while(end<arr.length) {
			sum-=arr[start];
			sum+=arr[end];
			max = Math.max(max, sum);
			start++;
			end++;
		}
		
		return (double)max/k;
	}
	public static void main(String[] args) {
		int[] arr = {1,12,-5,-6,50,3};
		
		int k = 4;
		
		System.out.println(getMaxAvgSum(arr,k));
	}
}
