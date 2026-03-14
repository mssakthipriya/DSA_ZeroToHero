package L.RecursionPattern;

public class AtoIRecurision {

	public static int getNum(int num,int index,String s) {
		if(index>=s.length() ) {
			return num;
		}
		char a=s.charAt(index);
		if(!Character.isDigit(a)){
			return num;
		}
		return getNum(num*10+Character.getNumericValue(a),index+1,s);
	}
	public static int atoiRec(String s) {
		s=s.trim();
		if(s==null || s.isEmpty()) return 0;
		int index=0;
		int sign=1;
		char first = s.charAt(0);
		if(first=='-') {
			sign =-1;
			index++;
		}else if(first=='+') {
			index++;
		}
			
				
		return sign*getNum(0,index,s);
	}
	public static void main(String[] args) {
		String s = "  -0001337c0d3";
		System.out.println(atoiRec(s));
	}
}
