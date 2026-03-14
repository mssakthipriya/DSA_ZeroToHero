package H.Arrays.Easy;

public class MaxOneCount {
	
	public static int consecutiveCount(int[] arr) {
		int count =0;
		int max = 0;
		for(int j=0;j<arr.length;j++) {
			if(arr[j]==1) {
				count++;
			}else {
				count=0;
			}
			if(max<count) {
				max=count;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1};
		
		System.out.println("The number of consecutive one's in the array is:"+consecutiveCount(arr));
		
	}

}
