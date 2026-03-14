package J.Strings.Easy;

public class LargestOddNumberInString {
	
	public static String largestOddNumber(String s) {
		String max = "";
		int num  = Integer.parseInt(s);
		for(int i=0;i<s.length();i++) {
			if(num%2==0) {
				num = num/10;
			}else {
				max = Integer.toString(num);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String num = "152";
		String oddNum = largestOddNumber(num);
		System.out.println("The largest odd number in the string is:"+ oddNum);
	}

}
