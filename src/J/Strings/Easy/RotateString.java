package J.Strings.Easy;

public class RotateString {
	
	public static boolean rotateStringII(String s, String goal) {
		if(s.length()!=goal.length())
			return false;
		return (s+s).contains(goal);
	}

	public static boolean rotateString(String s, String goal) {
		if(s.length()!=goal.length())
			return false;
		for(int i=0;i<s.length();i++) {
			char temp = s.charAt(0);
			if(s.equals(goal)){
				System.out.println(s);
				return true;
			}else {
				s = s.substring(1)+temp;
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		String s = "abcde";
		String goal = "cdeab";
		
		boolean flag = rotateString(s,goal);
		if(flag) {
			System.out.println("The string can be rotated to get the goal!");
		}else {
			System.out.println("The string cannot be rotated to get the goal!");
		}
		
		String s2 = "abcde";
		String goal2 = "cdeab";
		
		boolean flag2 = rotateStringII(s2,goal2);
		if(flag2) {
			System.out.println("The string can be rotated to get the goal!");
		}else {
			System.out.println("The string cannot be rotated to get the goal!");
		}
	}


}
