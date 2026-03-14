package T.Graphs.ShortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplications {
	public static int getMinSteps(int[] arr,int start,int end) {
		int mod = 100000;
		if(start==end) return 0;
		int[] dist = new int[mod];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {start,0});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int num = curr[0];
			int step = curr[1];

			for(int i=0;i<arr.length;i++) {
				int prod = (num*arr[i])%mod;
				if(step+1 < dist[prod]) {
					dist[prod] = step+1;
					
					if(prod==end) {
						return step+1;
					}
					q.add(new int[] {num*arr[i],step+1});
				}
				

			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int arr[] = {2, 5, 7};
		int start = 3;
		int end = 30;
		
		int steps = getMinSteps(arr,start,end);
		
		System.out.println(steps);
		
	}

}
