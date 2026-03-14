package P.Heaps.Medium;

import java.util.TreeMap;

public class HandsOfStraight {
	
    public static boolean isNStraightHand(int[] hand, int groupSize) {        
    	if(hand.length%groupSize!=0) return false;
    	
    	TreeMap<Integer,Integer> count = new TreeMap<>();
    	for(int i=0;i<hand.length;i++) {
    		count.put(hand[i], count.getOrDefault(hand[i], 0)+1);    		
    	}
    	
    	while(!count.isEmpty()) {
    	int curr = count.firstKey();
    	
    	for(int i=0;i<groupSize;i++) {
    		if(!count.containsKey(curr+i)) return false;
    		
    		count.put(curr+i, count.get(curr+i)-1);
    		if(count.get(curr+i)==0) {
    			count.remove(curr+i);
    		}
    	}
    	
    	}
    	
    	
    	return true;
    }
	public static void main(String[] args) {
		int[] hand = {1,2,3,6,2,3,4,7,8};
		
		int groupSize = 3;
		
		boolean check = isNStraightHand(hand,groupSize);
		
		System.out.println(check);
		
	}

}
