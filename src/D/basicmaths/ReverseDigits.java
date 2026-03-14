package D.basicmaths;

public class ReverseDigits {

	public static int getReversedDigit(int num) {
		int revDigit = 0;
		int deg;
		
		while(num>0) {
			deg= num%10;
			revDigit=(revDigit*10)+deg;
			num=num/10;
		
		}

		
		return revDigit;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("The reversed number is: "+getReversedDigit(12345000));
	}
}
