package F.Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
	
	public static void getFrequencies(int[] arr) {
		
		Map<Integer,Integer> freqMap = new HashMap<>();
		
		for(int i: arr) {
			if(freqMap.containsKey(i)) {
				freqMap.put(i, freqMap.get(i)+1);
			}else {
				freqMap.put(i,1);
			}
		}
		
		for(Map.Entry<Integer, Integer> ent: freqMap.entrySet()) {
			int key = ent.getKey();
			int val = ent.getValue();
			
			System.out.println("The number:"+key+" has frequency of: "+val);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {10,5,10,15,10,5};
		getFrequencies(arr);
	}

}
