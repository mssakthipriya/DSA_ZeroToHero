package W.Strings;

public class CountAndSay {

	public static String countAndSay(int n) {
		if(n==1) {
			return "1";
		}
		String s=countAndSay(n-1);
		
		String cs = "";
		int count = 1;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)==s.charAt(i-1)) {
				count++;
			}else {
				cs=cs+count;
				cs=cs+s.charAt(i-1);
			}
		}
		cs = cs+count+s.charAt(s.length()-1);

		return cs;
	}
	public static void main(String[] args) {
		int n = 4;
		String s = countAndSay(n);
		
		System.out.println(s);
	}
}
