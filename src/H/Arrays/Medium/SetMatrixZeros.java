package H.Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;



public class SetMatrixZeros {
	
	public static void setZeroesII(int[][] mat) {
		boolean firstRow = false;
		boolean firstCol = false;
		int m = mat.length;
		int n = mat[0].length;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j]==0) {
					if(i==0) firstRow=true;
					if(j==0) firstCol=true;
					mat[0][j]=0;
					mat[i][0]=0;
				}
			}	
		}
		

		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if((mat[0][j]==0 || mat[i][0]==0)) {
					mat[i][j]=0;
				}
			}	
		}
		
		if(firstRow) {
			for(int i=0;i<n;i++) {
				mat[0][i]=0;
			}
		}
		if(firstCol) {
			for(int i=0;i<m;i++) {
				mat[i][0]=0;
			}
		}
		
	}

	public static void setZeroes(int[][] mat) {
		ArrayList<Integer> col = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<>();
		int m = mat.length;
		int n = mat[0].length;
		System.out.println("m:"+m+":n:"+n);
		for(int i = 0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(mat[i][j]==0) {
				row.add(i);	
				col.add(j);
				}
			}
		}

		for(int r: row) {
			for(int i=0;i<n;i++) {
				mat[r][i]=0;
			}
		}
		for(int c: col) {
			for(int j=0;j<m;j++) {
				mat[j][c]=0;
			}
		}
	}
	public static void main(String[] args) {
		int[][] mat = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		
		//int[][] mat = {{1,1,1},{1,0,1},{1,1,1}};
		setZeroes(mat);
		
		for(int i=0;i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println("--------------");
		int[][] mat2 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		//int[][] mat2 = {{0,1,2,0},{3,4,0,2},{1,3,1,5},{8,7,6,9}};
		//int[][] mat2 = {{1,1,1},{1,0,1},{1,1,1}};
		//int[][] mat2 = {{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};
		setZeroesII(mat2);
		System.out.println("--------------");
		for(int i=0;i<mat2.length;i++) {
			System.out.println(Arrays.toString(mat2[i]));
		}
	}
}
