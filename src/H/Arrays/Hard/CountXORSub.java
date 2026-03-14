package H.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class CountXORSub {

	public static int getXORSubCount(int[] arr,int k) {
		Map<Integer,Integer> map = new HashMap<>();
		int count=0;
		int XOR = 0;
		map.put(XOR, 1);
		for(int i=0;i<arr.length;i++) {
			XOR=XOR^arr[i];
			int prefXOR = k^XOR;
			
			if(map.containsKey(prefXOR)) {
				count+=map.get(prefXOR);
			}
			
			if(map.containsKey(XOR)) {
				map.put(XOR, map.get(XOR)+1);
			}else {
				map.put(XOR, 1);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 2, 6, 4};
		int k = 6;
		int count = getXORSubCount(arr,k);
		
		System.out.println("The count of sub array with XOR is:"+count);
	}
}
