package T.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class AdjMatrix {
	
	private int vertices;
	private int[][] adjMatrix;
	
	public AdjMatrix(int vertices) {
		this.vertices = vertices;
		adjMatrix = new int[vertices+1][vertices+1];
	}
	
	public void addEdge(int i,int j) {
		adjMatrix[i][j] = 1;
		adjMatrix[j][i] = 1;
	}
	public void removeEdge(int i,int j) {
		adjMatrix[i][j] = 0;
		adjMatrix[j][i] = 0;
	}
	
	public void addVertex() {
		int oldVertices = adjMatrix.length;
		int[][] newAdj = new int[oldVertices+1][oldVertices+1];
		for(int i=1;i<=vertices;i++) {
			for(int j=1;j<=vertices;j++) {
				newAdj[i][j]=adjMatrix[i][j];
			}
		}
		adjMatrix = newAdj;
		vertices++;
	}
	
	public void removeVertix(int v) {
		int[][] newAdj = new int[vertices][vertices];
		int tempi = 1;
		for(int i=1;i<=vertices;i++) {
			if(i==v) continue;
			int tempj=1;
			for(int j=1;j<=vertices;j++) {
				if(j==v) continue;
				newAdj[tempi][tempj]=adjMatrix[i][j];
				tempj++;
			}
			tempi++;
		}
		adjMatrix=newAdj;
		vertices--;
	}
	
	public void printAdjMatrix() {
		for(int i=1;i<=vertices;i++) {
			for(int j=1;j<=vertices;j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public List<Integer> DFSItr(int start){
		List<Integer> ans = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> st = new Stack<>();
		
		st.push(start);
		while(!st.isEmpty()) {
			int node = st.pop();
			if(!visited.contains(node)) {
				ans.add(node);
				visited.add(node);
			}
			for(int i = adjMatrix[0].length - 1; i >= 0; i--) {
				if(adjMatrix[node][i]==1 && !visited.contains(i)) {
					st.push(i);
				}
			}
		}
		
		
		return ans;
	}
	
	public void DFSHelper(int start, boolean[] visited,List<Integer> ans){
		visited[start] = true;
		ans.add(start);
		
		for(int i=0;i<adjMatrix[start].length;i++) {
			if(adjMatrix[start][i]==1 && !visited[i]) {
				DFSHelper(i,visited,ans);
			}
		}
	}
	
	public List<Integer> DFSRec(int start){
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[adjMatrix.length] ;
		
		DFSHelper(start,visited,ans);
		return ans;
	}
	
	public List<Integer> BFS(int start){
		List<Integer> ans = new ArrayList<>();
		boolean[] visited = new boolean[adjMatrix.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);

			
			for(int i=0;i<adjMatrix[node].length;i++) {
				if(adjMatrix[node][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		AdjMatrix mat = new AdjMatrix(4);
		mat.addEdge(1, 2);
		mat.addEdge(2, 3);
		mat.addEdge(3, 4);
		mat.addEdge(4, 1);
		mat.printAdjMatrix();
		System.out.println("--------------");
		mat.addVertex();
		mat.addEdge(5, 3);
		mat.addEdge(5, 4);
		mat.printAdjMatrix();
		System.out.println("--------------");
		mat.addVertex();
		mat.addEdge(6, 5);
		mat.printAdjMatrix();
		System.out.println("--------------");
		mat.removeVertix(6);
		mat.printAdjMatrix();
		System.out.println("--------------");
		
		//DFS
		System.out.println("DFS:");
		List<Integer> dfsItrList = mat.DFSItr(1);
		System.out.println(dfsItrList.toString());
		List<Integer> dfsRecList = mat.DFSRec(1);
		System.out.println(dfsRecList.toString());
		//BFS
		System.out.println("BFS:");
		List<Integer> bfsList = mat.BFS(1);
		System.out.println(bfsList.toString());
	}

}
