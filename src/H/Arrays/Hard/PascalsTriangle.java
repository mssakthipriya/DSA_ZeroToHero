package H.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
	public static int nCr(int n, int r) {
		r=r-1;
		n=n-1;
		int pos = 1;
		for(int i=0;i<r;i++) {
			pos=pos*(n-i);
			pos=pos/(i+1);
		}
		
		return pos;
	}
	public static void getRow(int n) {
		n=n-1;
		int pos = 1;
		System.out.print(pos+" ");
		for(int i=0;i<n;i++) {
			pos=pos*(n-i);
			pos=pos/(i+1);
			System.out.print(pos+" ");
		}
		System.out.println();
	}
	public static List<List<Integer>> pascalTriangle(int n) {
		List<List<Integer>> pasc = new ArrayList<>();
		n=n-1;
		for(int j=0;j<=n;j++) {
			int pos = 1;
			List<Integer> temp = new ArrayList<>();
			temp.add(pos);
		for(int i=0;i<j;i++) {
			pos=pos*(j-i);
			pos=pos/(i+1);
			temp.add(pos);
		}
		pasc.add(temp);
		}
		
		return pasc;
	}
	public static void createPascalsTriangle(int n) {
		int[][] pas = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 ||j==i) {
					pas[i][j]=1;
				}else {
					pas[i][j]=pas[i-1][j-1]+pas[i-1][j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(Arrays.toString(pas[i]));
		}
	}
	
	public static void main(String[] args) {
		createPascalsTriangle(5);
		int n = 5;
		int r = 3;
		int element = nCr(n,r);
		System.out.println("The element in the position is:"+element);
		getRow(n);
		System.out.println("----------");
		List<List<Integer>> p = pascalTriangle(5);
		for(List<Integer> e : p) {
			System.out.println(e.toString());
		}
	}
}
