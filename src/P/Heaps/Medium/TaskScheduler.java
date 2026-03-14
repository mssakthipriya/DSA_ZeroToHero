package P.Heaps.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static int getMinimumTime(char[] tasks,int n ) {
		int[] freq = new int[26];
		for(int i=0;i<tasks.length;i++) {
			freq[tasks[i]-'A']++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<freq.length;i++) {
			if(freq[i]>0) {
				pq.add(freq[i]);
			}
		}
		int time = 0;
		
		while(!pq.isEmpty()) {
			List<Integer> store = new ArrayList<>();
			for(int i=0;i<n+1;i++) {
				if(!pq.isEmpty()) {
					store.add(pq.poll()-1);
				}
			}
			for(int f:store) {
				if(f>0) {
					pq.add(f);
				}
			}
			
			if(pq.isEmpty()) {
				time+=store.size();
			}else {
				time+=(n+1);
			}
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		char[] task = {'A','A','A','B','B','B'};
		int n = 3;
		
		int count = getMinimumTime(task,n);
		
		System.out.println(count);
	}
}
