package O.SlidingWindowTwoPointer.Medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
	
	public static int getMaxFruits(int[] fruits) {
		int max =0;
		int start = 0;
		int end =0;
		Map<Integer,Integer> basket = new HashMap<>();
		
		for(end = 0;end<fruits.length;end++) {
			int currCount = basket.getOrDefault(fruits[end], 0);
			basket.put(fruits[end], currCount+1);
			
			while(basket.size()>2) {
				int fruitCount = basket.get(fruits[start]);
				if(fruitCount==1) {
					basket.remove(fruits[start]);
				}else {
					basket.put(fruits[start], fruitCount-1);
				}
				start++;
			}
			
			//System.out.println(start+","+end);
			max = Math.max(max, end-start+1);
		}
			
		return max;
	}
	public static void main(String[] args) {
		
		int[] fruits = {1,2,1,1,3,4,2,2,2,2,4};
		
		System.out.println(getMaxFruits(fruits));
	}

}
