package H.Arrays.Medium;

public class ArrayLeaders {

	public static void printLeaders(int[] arr) {
		int n = arr.length-1;
		int max = arr[n];
		for(int i=n;i>=0;i--) {
			if(arr[i]>=max) {
				max = arr[i];
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 22, 12, 3, 0, 6};
		printLeaders(arr);
	}
}
