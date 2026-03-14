package J.Strings.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String frequencySort(String s) {
    	Map<Character,Integer> map = new HashMap<>();
    	String sortedS = "";
    	for(int i=0;i<s.length();i++) {
    		if(map.containsKey(s.charAt(i))) {
    			map.put(s.charAt(i), map.get(s.charAt(i))+1);
    		}else {
    			map.put(s.charAt(i), 1);
    		}
    	}
    	PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
    			(a,b) -> b.getValue() - a.getValue()
    			);
    	
    	pq.addAll(map.entrySet());
    	while(!pq.isEmpty()) {
    		Map.Entry<Character, Integer> e = pq.poll();
    		String temp = e.getKey().toString();
    		temp = temp.repeat(e.getValue());
    		System.out.println("temp:"+temp);
    		sortedS+=temp;
    	}
    	
    	System.out.println("sortedS:"+sortedS);
    	return sortedS;
    }
	public static void main(String[] args) {
		String str ="Aabb";
		String sorted = frequencySort(str);
		System.out.println("The String "+str+"is sorted as:"+ sorted);
	}
}
