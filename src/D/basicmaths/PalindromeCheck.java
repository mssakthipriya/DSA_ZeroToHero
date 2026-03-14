package D.basicmaths;

public class PalindromeCheck {
	
	public static void checkPalindrome(int num) {
		int revNum = revNum(num);
		if(revNum == num)
			System.out.println("Its a palindrom!");
		else
			System.out.println("Its not a palindrom!");

	}
	
	public static int revNum(int num) {
		int rev=0;
		
		while(num>0) {
			int dig = num%10;
			rev = (rev*10)+dig;
			num/=10;
		}
		
		return rev;
	}
	
	public static void main(String[] args) {
		checkPalindrome(1331);
	}

}
