package Q.GreedyAlgorithms.MediumHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i=0;
        
        while(i<n && intervals[i][1]<newInterval[0]) {
        	result.add(intervals[i]);
        	i++;
        }
        
        while(i<n && intervals[i][0]<=newInterval[1]) {
        	newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
        	newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
        	i++;
        }
        result.add(newInterval);
        
        while(i<n) {
        	result.add(intervals[i]);
        	i++;
        }
        
        return result;
    }
	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		
		List<int[]> newIntervals = insert(intervals, newInterval);
		for(int[] inter : newIntervals) {
			System.out.print(Arrays.toString(inter)+" ");
		}
	}

}
