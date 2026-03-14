package L.RecursionPattern.Combos;

import java.util.ArrayList;

public class RatInAMaze {
	
	public static void solve(int i,int j,int[][] maze,int[][] vis,int[] dx,int[] dy, String path, ArrayList<String> ans) {
		int n = maze.length;
		
		if(i==n-1 && j==n-1) {
			ans.add(path);
			return;
		}
		for(int k=0;k<4;k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			String dir = "DLRU";
			if(x>=0 && y>=0 && x<n && y<n && vis[x][y]!=1 && maze[x][y]==1) {
				vis[x][y]=1;
				solve(x,y,maze,vis,dx,dy,path+dir.charAt(k),ans);
				vis[x][y]=0;
			}
			
		}
		
	}
	public static ArrayList<String> getPaths(int[][] maze){
		int n = maze.length;				
		ArrayList<String> ans = new ArrayList<>();
		int[][] vis = new int[n][n];
		int[] dx = {1,0,0,-1};
		int[] dy = {0,-1,1,0};
		if(maze[0][0] == 1)
			solve(0,0,maze,vis,dx,dy,"",ans);
		
		return ans;
	}
	public static void main(String[] args) {
		int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
		
		ArrayList<String> ans = getPaths(maze);
		
		System.out.println(ans);
	}

}
