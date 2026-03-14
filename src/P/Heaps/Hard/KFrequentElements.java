package P.Heaps.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {
	
	public static int[] getFreqElement(int[] arr,int k) {
		int[] freq = new int[k];
		Map<Integer,Integer> hashMap = new HashMap<>();
		PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((entry1,entry2)->entry2.getValue().compareTo(entry1.getValue()));
		
		for(int i=0;i<arr.length;i++) {
			hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
		}
		
		System.out.println(hashMap.toString());
		for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
			pq.add(entry);
		}
		
		for(int i=0;i<k;i++) {
			freq[i]=pq.poll().getKey();
		}
		
		return freq;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
		int k = 2;
		
		int[] freqEle = getFreqElement(arr,k);
		
		System.out.println(Arrays.toString(freqEle));
	}

}
