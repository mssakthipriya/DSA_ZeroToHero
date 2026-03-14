package D.basicmaths;

public class PrimeChecker {
	
	public static void checkPrime(int num) {
		boolean flag=true;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				flag = false;
				break;
			}
		}
		
		if(flag==true) {
			System.out.println("The number is prime");
		}else {
			System.out.println("The number is not prime");
		}
		
	}
	
	public static void main(String[] args) {
		checkPrime(11);
	}

}
