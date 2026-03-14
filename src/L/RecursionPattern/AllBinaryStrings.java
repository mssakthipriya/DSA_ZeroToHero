package L.RecursionPattern;

import java.util.Arrays;

public class AllBinaryStrings {
	public static void genBinStrings(int n, int index,int[] ans) {
		if(index==n) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		
		ans[index]=0;
		genBinStrings(n, index+1, ans);

		ans[index]=1;
		genBinStrings(n, index+1, ans);

		
	}
	public static void main(String[] args) {
		int n = 3;
		int[] arr = new int[3];
		genBinStrings(n,0,arr);
	}

}
