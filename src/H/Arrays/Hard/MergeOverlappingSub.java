package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSub {
	
	public static int[][] getMergedArray(int[][] intervals){
		List<int[]> merged = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int start = intervals[0][0];
		int end = intervals[0][1];
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][0]<= end) {
				end = Math.max(end, intervals[i][1]);
			}else {
				merged.add(new int[] {start,end});
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		merged.add(new int[] {start,end});

		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		//int[][] arr = {{1,2}, {3,3}, {4,5}, {6,7}, {8,9}, {11,12}};
		int[][] arr = {{1,4}, {2,3}, {6,9}, {7,10}, {12,15}};
		
		int[][] mergedArr = getMergedArray(arr);
		
		for(int[] e: mergedArr) {
			System.out.print(Arrays.toString(e)+",");
		}
	}
}
