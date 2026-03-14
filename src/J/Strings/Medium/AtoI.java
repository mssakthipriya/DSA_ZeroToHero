package J.Strings.Medium;

public class AtoI {

	public static int myAtoi(String s) {
		int num=0;
		int i=0;
		boolean flag = false;
		s=s.trim();
		if(s.length()==0) return 0;
		if(s.charAt(0)=='-'||s.charAt(0)=='+') {
			i++;
			flag = s.charAt(0)=='-';
		}
	
		while(i<s.length() && Character.isDigit(s.charAt(i))) {		
            int digit = Character.getNumericValue(s.charAt(i));				
            if (num > (Integer.MAX_VALUE / 10) || (num == (Integer.MAX_VALUE / 10) && digit > 7)){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

          num=num*10+digit;
			i++;
		}
		
		if(flag) {
			num*=-1;
		}
		
		return num;
	}
	public static void main(String[] args) {
		String s = "  -0001337c0d3";
		//String s = "0-1";
		//-1337
		System.out.println("The number from the string is:"+myAtoi(s));
	}
}
