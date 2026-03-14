package W.Strings;
//{'0','1','2','3','4','5','6','7','8'};
//{'A','B','A','B','C','A','B','A','B'};
//{'0','0','1','2','0','1','2','3','4'};
public class KMP {
	public static int[] computeKMP(char[] pattern) {
		int[] kmp = new int[pattern.length];
		int index = 0;
		int i=1;
		while (i < pattern.length) {
			if(pattern[i]==pattern[index]) {
				kmp[i]=index+1;
				index++;
				i++;
			}else {
				if(index!=0) {
					index=kmp[index-1];
				}else {
					kmp[i]=0;
					i++;
				}
			}
		}
		
		
		return kmp;
	}
	public static int getSubString(String haystack,String needle) {
		int index = -1;
		char[] text = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
		int[] kmp = computeKMP(pattern);
		int i=0;
		int j=0;
		while(i<text.length && j<pattern.length) {
			if(text[i]==pattern[j]) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j=kmp[j-1];
				}else {
					i++;
				}				
			}
			if(j==pattern.length) {
				index = i-j;
				break;
			}
		}
		return index;
	}
	public static void main(String[] args) {
		String haystack = "sadbutsad";
		String needle = "sad";
		int index = getSubString(haystack,needle);
		System.out.println(index);
	}

}
