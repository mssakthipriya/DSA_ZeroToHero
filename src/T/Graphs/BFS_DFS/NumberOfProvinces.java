package T.Graphs.BFS_DFS;

public class NumberOfProvinces {
	public static void dfs(int start, boolean[] visited, int[][] isConnected) {
		visited[start]=true;
		for(int i=0;i<isConnected.length;i++) {
			if(isConnected[start][i]==1 &&!visited[i]) {
				visited[i]=true;
				dfs(i,visited,isConnected);
			}
		}
	}
	public static int findCircleNum(int[][] isConnected) {
		int v = isConnected.length;
		boolean[] visited = new boolean[v];
		int count = 0;

		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				count++;
				dfs(i,visited,isConnected);
			}
		}
		
		return count;
	}
	public static void main(String[] args) {
		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		
		int count = findCircleNum(isConnected);
		
		System.out.println(count);

	}
}
