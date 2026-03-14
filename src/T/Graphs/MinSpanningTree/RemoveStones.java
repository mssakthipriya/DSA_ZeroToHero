package T.Graphs.MinSpanningTree;

import java.util.HashSet;
import java.util.Set;

public class RemoveStones {
	public static int removeStones(int[][] stones) {
		int n = stones.length;
        
        int maxRow = 0;
        int maxCol = 0;
        for(int[] it: stones) {
        	maxRow = Math.max(maxRow, it[0]);
        	maxCol = Math.max(maxCol, it[1]);
        }
        DisjointSet dj = new DisjointSet(maxRow+maxCol+2);
        Set<Integer> uniqueNodes = new HashSet<>();
        for(int[] edg : stones) {
        	int nodeRow = edg[0];
        	int nodeCol = edg[1]+maxRow + 1;
        	dj.unionbySize(nodeRow, nodeCol);
        	uniqueNodes.add(nodeRow);
        	uniqueNodes.add(nodeCol);
        }
        Set<Integer> components = new HashSet<>();
        for(int node : uniqueNodes) {
        	components.add(dj.findUParent(node));
        }
		return n-components.size();
    }
	public static void main(String[] args) {
	
	int[][] stones = {{0, 0},{ 0, 1},{1, 0},{1, 2},{2, 1},{2, 2}};
	
	int maxRemoved = removeStones(stones);
	System.out.println(maxRemoved);
	}

}
