package J.Strings.Easy;

public class RemoveOuterParanthesis {

	public static String removePar(String s) {
		int count = 0;
		StringBuilder newS = new StringBuilder();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				count++;
				if(count>1)
					newS.append('(');
			}else {
				count--;
				if(count>0)
					newS.append(')');
			}

		}
		
		return newS.toString();
	}
	
	public static void main(String[] args) {
		String par = "(()())(())(()(()))";
		String newPar = removePar(par);
		System.out.println("After removing the paranthesis, the new string is:"+newPar);
	} 
	
}
