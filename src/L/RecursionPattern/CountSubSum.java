package L.RecursionPattern;

public class CountSubSum {
	public static int getCount(int[] arr, int k,int i,int sum) {
		if(i==arr.length) {
			if(sum==k) {
				return 1;
			}else {
				return 0;
			}
		}
		int take = getCount(arr, k, i + 1, sum + arr[i]);
		int notTake=getCount(arr, k,i+1,sum);
		
		return take + notTake;
	}
	public static void main(String[] args) {
		int[] arr = {4, 2, 10, 5, 1, 3};
		int k=5;
		int count = getCount(arr,k,0,0);
		System.out.println("The number of subsequence with sum "+k+" is:"+count);
	}

}
