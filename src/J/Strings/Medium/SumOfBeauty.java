package J.Strings.Medium;

public class SumOfBeauty {
	
	public static int getSumofBeauty(String s) {
		int sum = 0;
		int n = s.length();

		
		for(int i=0;i<n;i++) {
			int freq[] = new int[26];
			for(int j=i;j<n;j++) {
				freq[s.charAt(j)-'a']++;
				if(j-i+1>2) {
				sum+=getBeauty(freq);
				}
			}
			
		}
		return sum;
	}
	
	public static int getBeauty(int[] freq) {
		int diff = 0;
		int maxFreq = 0;
		int minFreq = Integer.MAX_VALUE;
		for(int e: freq) {
			if(e>0) {
			maxFreq = Math.max(maxFreq, e);
			minFreq = Math.min(e, minFreq);
			}
		}
		diff = maxFreq-minFreq;
		return diff;
	}
	public static void main(String[] args) {
		String s ="aabcb";
		
		int ans = getSumofBeauty(s);
		
		System.out.println("The sum of beauty of substrings of the string is:"+ans);
	}

}
