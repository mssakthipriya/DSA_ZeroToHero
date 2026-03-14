package D.basicmaths;

public class ArmStrongNumber {
	
	public static void checkArmstrongNum(int n) {
		int num = n;
		int arm = 0;
		//or you can use: 
		//int len2 = String.valueOf(num).length();
		int len = (int) Math.log10(num)+1;
		
		for(int i=0; i<len;i++) {
			arm += (int) Math.pow(num%10, len);
			num/=10;
		}
		
		if(arm==n) {
			System.out.println("Yes, its an armstrong number!");
		}else {
			System.out.println("Sorry! its not an amrnstrong number!");
		}

	}
	
public static void main(String[] args) {
	checkArmstrongNum(371);
}
}
