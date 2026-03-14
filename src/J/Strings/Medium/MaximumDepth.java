package J.Strings.Medium;

public class MaximumDepth {
	
	public static int getMaxDepth(String str) {
		int max = 0;
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				count++;
			}
			if(str.charAt(i)==')') {
				count--;
			}
			max = Math.max(max, count);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String str = "(1+(2*3)+((8)/4))+1";
		
		System.out.println("The maximum depth of the paranthesis is:"+getMaxDepth(str));
	}

}
