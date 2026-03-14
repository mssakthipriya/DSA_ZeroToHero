package Q.GreedyAlgorithms;

public class ValidParanthesis {

	public static boolean checkValidParanthesis(String s) {
		int min = 0;
		int max = 0;
		
		for(char c:s.toCharArray()) {
			if(c=='(') {
				min++;
				max++;
			}else if(c==')') {
				min--;
				max--;
			}else {
				min--;
				max++;
			}
			if(max<0) return false;
			min = Math.max(min, 0);
		}
		
		return min==0;
	}
	public static void main(String[] args) {
		String s = "(*))";
		//String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
		//String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
		boolean check = checkValidParanthesis(s);
		System.out.println(check);
	}
}
