package T.Graphs.ShortestPath;

import java.util.Arrays;

public class ConnectedCities {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++) {
        	Arrays.fill(matrix[i], -1);
        	matrix[i][i]=0;
        }
        
        for(int i=0;i<edges.length;i++) {
        	int a = edges[i][0];
        	int b = edges[i][1];
        	int wt = edges[i][2];
        	
        	matrix[a][b]=wt;
        	matrix[b][a]=wt;
        }
        
        for(int k=0;k<n;k++) {
        	
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			
        			if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;
        			
        			if((matrix[i][k]+matrix[k][j]<matrix[i][j]|| matrix[i][j]==-1) && matrix[i][k]+matrix[k][j]<=distanceThreshold) {
        				matrix[i][j]= matrix[i][k]+matrix[k][j];
        			}
        		}
        	}
        }
        
        int cityNumber = -1;
        int cityCnt = n;
        for(int i=0;i<n;i++) {
        	int count = 0;
        	for(int j=0;j<n;j++) {
        		if(matrix[i][j]!=0 && matrix[i][j]!=-1) {
        			count++;
        		}
        	}
        	if(count<cityCnt) {
        		cityCnt = count;
        		cityNumber = i;
        	}else if(count==cityCnt) {
        		if(i>cityNumber) {
        			cityNumber = i;
        		}
        	}
        }
        

    	return cityNumber;
    }
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		int distanceThreshold = 4;
		
		int city = findTheCity(n,edges,distanceThreshold);
		
		System.out.println(city);
	}
}
