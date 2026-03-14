package Q.GreedyAlgorithms.MediumHard;

import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int erase = 0;
        int cnt = 0;
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt((int[] a)-> a[1]));
        int lastInter = -1;
       for(int[] inter : intervals) {
    	   System.out.println(Arrays.toString(inter));
    	   if(inter[0]>=lastInter) {
    		   cnt++;
    		   lastInter = inter[1];
    	   }
       }
       
       erase = n-cnt;
        
        return erase;
    }
	public static void main(String[] args) {
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
		
		int removals = eraseOverlapIntervals(intervals);
		
		System.out.println(removals);
	}

}
