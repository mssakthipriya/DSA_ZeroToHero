package W.Strings;

public class ValidParenthesisMaker {
	public static int getMinMoves(String s) {
		int count = 0;
		int missing = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(') {
				count++;
			}else {
				if(count==0) {
					missing++;
				}else {
					count--;
				}
			}
		}
		
		
		return count+missing;
	}
	public static void main(String[] args) {
		String s = "())";
		
		int count = getMinMoves(s);
		
		System.out.println(count);
	}

}
