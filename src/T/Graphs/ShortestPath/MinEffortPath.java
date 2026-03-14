package T.Graphs.ShortestPath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinEffortPath {
	
    public static int minimumEffortPath(int[][] heights) {
    	int n = heights.length;
    	int m = heights[0].length;
    	
    	int[][] dist = new int[n][m];
    	for(int i=0;i<n;i++) {
    		Arrays.fill(dist[i], Integer.MAX_VALUE);
    	}
    	
    	dist[0][0] = 0;
    	
    	PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    	q.add(new int[] {0,0,0});
    	
    	int[] dx = {-1,1,0,0};
    	int[] dy = {0,0,1,-1};
    	
    	while(!q.isEmpty()) {
    		int[] point = q.poll();
    		int x = point[0];
    		int y = point[1];
    		int diff = point[2];
    		
    		if(x==n-1 && y==m-1) {
    			
    			for(int i=0;i<n;i++) {
    				System.out.println(Arrays.toString(dist[i]));
    			}
    			
    			return diff;
    		}
    		
    		for(int i=0;i<4;i++) {
    			int xi = x+dx[i];
    			int yi = y+dy[i];   
    			
    			if(xi>=0 && yi>=0 && xi<n && yi <m) {
    				
        			int newEffort = Math.max(Math.abs(heights[x][y]-heights[xi][yi]), diff);
    				
        			if(newEffort < dist[xi][yi]) {
        				dist[xi][yi] = newEffort;
        				q.add(new int[] {xi,yi,newEffort});
        			}
    			}
    					
    		}
    		
    	}
    	
    	return 0;
    }
	public static void main(String[] args) {
		int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
		
		int minEffort = minimumEffortPath(heights);
		
		System.out.println("Minimum effort taken is:"+ minEffort);
	}

}
