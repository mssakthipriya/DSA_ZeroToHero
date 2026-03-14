package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {
	
	public static int networkDelayTime(int[][] times, int n, int k) {
       List<List<int[]>> adj = new ArrayList<>();
       for(int i=0;i<=n;i++) {
    	   adj.add(new ArrayList<>());
       }
       
       for(int[] p : times) {
    	   adj.get(p[0]).add(new int[] {p[1],p[2]});
       }
       int[] dist = new int[n+1];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[0]=-1;
       dist[k]=0;
       
       PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
       q.add(new int[] {k,0});
       
       while(!q.isEmpty()) {
    	   int[] points = q.poll();    	   
    	   int src = points[0];
    	   int time = points[1];
    	   
    	   for(int[] dest : adj.get(src)) {
    		   int d = dest[0];
    		   int t = dest[1];
    		   if(time+t < dist[d]) {
    			   dist[d] = time+t;
    			   q.add(new int[] {d,time+t});
    		   }
    		   
    	   }
    	   
       }
       
       System.out.println(Arrays.toString(dist));
       
       int max = 0;
       for(int i=0;i<=n;i++) {
    	   if(dist[i]==Integer.MAX_VALUE) return -1;
    	   max = Math.max(max, dist[i]);
       }    
       
		return max;
    }
	public static void main(String[] args) {
		 int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		 int n = 4;
		 int k = 2;
		 
		 int minTime = networkDelayTime(times,n,k);
		 
		 System.out.println("Min network delay:"+minTime);
	}

}
