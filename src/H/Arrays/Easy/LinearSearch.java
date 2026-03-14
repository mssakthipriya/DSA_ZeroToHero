package H.Arrays.Easy;

public class LinearSearch {
	
	public static int searchLinear(int[] arr, int num) {
		int index = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==num) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = 4;
		System.out.println("The numeber "+n+ " is found in the index "+searchLinear(arr,n));
	}
	
	
}
