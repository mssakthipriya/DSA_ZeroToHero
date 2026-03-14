package W.Strings;

import java.util.Arrays;

public class ZFunction {
	public static int[] zfuntion(char[] text) {
		int[] z = new int[text.length];
		int left = 0;
		int right = 0;
		for(int k=1;k<text.length;k++) {
			if(k>right) {
				left=right=k;
				while(right<text.length && text[right]==text[right-left]) {
					right++;
				}
				z[k]=right-left;
				right--;
			}else {
				int k1 = k-left;
				if(z[k1]< right-k+1) {
					z[k]=z[k1];
				}else {
					left = k;
					while(right<text.length && text[right]==text[right-left]) {
						right++;
					}
					z[k]=right-left;
					right--;
				}
			}
		}
		return z;
	}
	public static int getNeedleIndex(String haystack,String needle) {
		int index = -1;
		int n = needle.length();
		int h = haystack.length();
		char[] text = new char[h+n+1];
		for(int i=0;i<n;i++) {
			text[i]=needle.charAt(i);
		}
		text[n]='$';
		
		for(int i=n+1;i<text.length;i++) {
			text[i]=haystack.charAt(i-n-1);
		}
		System.out.println(text);
		int[] z = zfuntion(text);
		//System.out.println(Arrays.toString(z));
		for(int i=0;i<z.length;i++) {
			if(z[i]==needle.length()) {
				index = i-needle.length()-1;
				break;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		String haystack = "sadbutsad";
		String needle = "sad";
		
		int index = getNeedleIndex(haystack,needle);
		
		System.out.println(index);
		
	}

}
