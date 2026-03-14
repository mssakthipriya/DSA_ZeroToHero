package Q.GreedyAlgorithms.MediumHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NMeetingsOneRoom {

	public static List<Integer> getMaxMeetings(int[] start,int[] end) {
		int n = start.length;
		List<Integer> meets = new ArrayList<>();
		
		List<int[]> meetings = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			meetings.add(new int[] {end[i],start[i],i+1});
		}
		
		meetings.sort(Comparator.comparingInt(a->a[0]));
		int lastMeeting = -1;
		for(int[] meeting:meetings) {
			if(meeting[1]>lastMeeting) {
				meets.add(meeting[2]);
				lastMeeting = meeting[0];
			}
		}
		
		return meets;
		
	}
	public static void main(String[] args) {
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,5,7,9,9};
		int n = 6;
		List<Integer> meets = getMaxMeetings(start,end);
		
		System.out.println(meets.toString());
	}
}
