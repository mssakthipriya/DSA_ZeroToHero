package F.Hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestLowestFrequencies {
	
	public static void getFrequencies(int[] arr) {
		Map<Integer, Integer> freq = new HashMap<>();
		
		for (int i : arr) {
			if(freq.containsKey(i))
				freq.put(i, freq.get(i)+1);
			else
				freq.put(i, 1);
			
		}
		int maxFreq = 0;
		int minFreq = arr.length;
		int maxEl = 0;
		int minEl = 0;
		
		
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			
			if(val>maxFreq) {
				maxFreq = val;
				maxEl = key;
			}
			
			if(val<minFreq) {
				minFreq = val;
				minEl = key; 
			}
			
		}
		
		System.out.println("The number with higest frquency is: "+maxEl+" having a ffrequency of "+maxFreq);
		System.out.println("The number with lowest frquency is: "+minEl+" having a ffrequency of "+minFreq);
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2,2,3,4,4,2};
		
		getFrequencies(arr);
	}

}
