package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberofWaysToDestination {
	
    public static int countPaths(int n, int[][] roads) {
        int count = 0;
        int mod = (int)(1e9+7);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int[] point : roads) {
        	adj.get(point[0]).add(new int[] {point[1],point[2]}); 
        	adj.get(point[1]).add(new int[] {point[0],point[2]}); 
        }
        
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
        	int[] point = q.poll();
        	int node = point[0];
        	int t = point[1];
        	for(int[] adjPoint : adj.get(node)) {
        		int adjNode = adjPoint[0];
        		int adjTime = adjPoint[1];
        		
        		if(t+adjTime<time[adjNode]) {
        			time[adjNode] = t+adjTime;
        			q.add(new int[] {adjNode,t+adjTime});
        			ways[adjNode] = ways[node];
        		}else if(t+adjTime==time[adjNode]) {
        			ways[adjNode] =(ways[adjNode]+ ways[node])%mod;
        		}
        	}
        }
        
        return ways[n-1];
    }
	public static void main(String[] args) {
		int n = 7;
		int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		
		int count = countPaths(n,roads);
		
		System.out.println(count);
	}

}
