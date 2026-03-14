package T.Graphs.MinSpanningTree;
 
import java.util.PriorityQueue;

public class SwimRisingWater {
	public static int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] vis = new int[n][n];
        
        pq.add(new int[] {grid[0][0],0,0});
    	vis[0][0] = 1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        while(!pq.isEmpty()) {
        	int[] node = pq.poll();
        	int elevation = node[0];
        	int row = node[1];
        	int col = node[2];
        	
        	if(row==n-1 && col==n-1) return elevation;

        	for(int i=0;i<4;i++) {
        		int adjr = row+dx[i];
        		int adjc = col+dy[i];
        		
        		if(adjr>=0 && adjc>=0 && adjr<n && adjc<n && vis[adjr][adjc]==0) {
        			vis[adjr][adjc] = 1;
        			pq.add(new int[] {Math.max(elevation,grid[adjr][adjc]),adjr,adjc});
        		}
        	}
        	
        	
        }
        
        return -1;
    }
	public static void main(String[] args) {
		int[][] grid = {{ 0, 1, 2, 3, 4},{24,23,22,21, 5},{12,13,14,15,16},{11,17,18,19,20},{10, 9, 8, 7, 6}};
		
		int time = swimInWater(grid);
		System.out.println(time);
	}
}
