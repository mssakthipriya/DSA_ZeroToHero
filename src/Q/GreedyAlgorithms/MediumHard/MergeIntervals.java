package Q.GreedyAlgorithms.MediumHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static List<int[]> getMergedIntervals(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		
		for(int[] interval : intervals) {
			
			if(result.isEmpty() || interval[0]> result.get(result.size()-1)[1]) {
				result.add(interval);
			}else {
				int last = result.size()-1;
				int maxVal = Math.max(result.get(last)[1], interval[1]);
				result.get(last)[1]= maxVal;
			}
			
			
		}
		
		return result;
	}
	public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        List<int[]> result = getMergedIntervals(intervals);
        
        for(int[] res : result) {
        	System.out.print(Arrays.toString(res)+" ");
        }
	}
}
