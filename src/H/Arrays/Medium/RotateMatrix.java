package H.Arrays.Medium;

import java.util.Arrays;

public class RotateMatrix {
	
	public static void rotateII(int[][] mat) {
		int n = mat.length;
		//Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				int temp = mat[i][j];
				mat[i][j]= mat[j][i];
				mat[j][i]= temp;
				
			}
		}
		//Step 2: Reverse each row of the matrix.
		for(int i=0;i<n;i++) {
			for(int j=0;j<=n/2;j++) {
				int temp = mat[i][j];
				mat[i][j]= mat[i][n-1-j];
				mat[i][n-1-j]= temp;
				
			}
		}
	}
	
	public static void rotate(int[][] mat) {
		int n = mat.length;
		for(int i=0;i<(n+1)/2;i++) {
			for(int j=0;j<n/2;j++) {
				int temp = mat[n-1-j][i];
				mat[n-1-j][i] = mat[n-1-i][n-1-j];
				mat[n-1-i][n-1-j] = mat[j][n-1-i];
				mat[j][n-1-i] = mat[i][j];
				mat[i][j] = temp;
				
			}
			
			System.out.println("--------------");
			for(int k=0;k<mat.length;k++) {
				System.out.println(Arrays.toString(mat[k]));
			}
			System.out.println("--------------");
		}
		
	}

	public static void main(String[] args) {
		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("---------------");
		rotate(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("---------------");
		int arr2[][] = {{1,2,3},{4,5,6},{7,8,9}};
		rotateII(arr2);
		
		for(int i=0;i<arr2.length;i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		
	}
}
