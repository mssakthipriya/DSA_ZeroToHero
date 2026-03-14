package H.Arrays.Medium;

import java.util.Arrays;

public class RearrangeBySign {
	
public static int[] rearrangeBySign(int[] arr) {
	int[] reArray = new int[arr.length];
	int pos = 0;
	int neg = 1;
	for(int i=0;i<arr.length;i++) {
		if(arr[i]>=0) {
			reArray[pos] = arr[i];
			pos+=2;
		}else {
			reArray[neg] = arr[i];
			neg+=2;
		}
	}
	
	
	return reArray;
}
public static void main(String[] args) {
	int[] arr = {1,2,-3,-1,-2,3};
	int[] reArray = rearrangeBySign(arr);
	System.out.println("The rearranged array is:"+Arrays.toString(reArray));
}
}
