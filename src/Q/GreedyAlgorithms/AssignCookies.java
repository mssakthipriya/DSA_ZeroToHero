package Q.GreedyAlgorithms;

import java.util.Arrays;

public class AssignCookies {
	
	public static int getMaxAllotment(int[] g,int[] s) {
		int left = 0;
		int right = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		
		while(left<g.length && right<s.length) {
			if(g[left]<=s[right]) {
				left++;
			}
			right++;
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] greed = {1, 5, 3, 3, 4};
		int[] size = {4, 2, 1, 2, 1, 3};
		
		System.out.println(getMaxAllotment(greed,size));
	}

}
