package T.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class CheapestFlightsKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int[] info : flights) {
        	int a = info[0];
        	int b = info[1];
        	int price = info[2];
        	
        	adj.get(a).add(new int[] {b,price});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        //node,price,stops
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[] {src,0,0});
        
        while(!q.isEmpty()) {
        	int[] info = q.poll();
        	
        	int point = info[0];
        	int price = info[1];
        	int stops = info[2];
        	
        	if(stops>k) continue;
        	
        	for(int[] b : adj.get(point)) {
        		int dest = b[0];
        		int dprice = b[1];
        		if(dist[dest]>price+dprice) {
        			dist[dest] = price+dprice;
        			q.add(new int[] {dest,price+dprice,stops+1});
        		}
        		
        	}
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
    	return dist[dst];
    }
	public static void main(String[] args) {
/*		  int n = 4;
		  int[][] flights = {{0, 1, 100},{1, 2, 100},{2, 0, 100},{1, 3, 600},{2, 3, 200}};  
		  int src = 0; 
		  int dst = 3;
		  int k = 1; */
		  
		  int n = 3;
		  int[][] flights = {{0, 1, 100},{1, 2, 100},{0, 2, 500}};  
		  int src = 0; 
		  int dst = 2;
		  int k = 1;
		  
		  int cheapestRate = findCheapestPrice(n,flights,src,dst,k);
		  
		  System.out.println("The cheapest price is:"+cheapestRate);
	}

}
