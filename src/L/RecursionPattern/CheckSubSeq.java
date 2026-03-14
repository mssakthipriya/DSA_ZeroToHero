package L.RecursionPattern;

public class CheckSubSeq {
	public static boolean checkSubSum(int[] arr, int k,int i,int sum) {
		if(i==arr.length) {
			return sum==k;
		}
		if(checkSubSum(arr,k,i+1,sum+arr[i]))
			return true;
		if(checkSubSum(arr,k,i+1,sum))
			return true;
				
		return false;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int k=8;
		boolean check = checkSubSum(arr,k,0,0);
		System.out.println(check);
	}

}
