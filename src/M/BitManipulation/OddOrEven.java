package M.BitManipulation;

public class OddOrEven {
	
	public static boolean checkOddEven(int n){
		if(n%2==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		int n=8;
		
		boolean check = checkOddEven(n);
		
		if(check) {
			System.out.println("The number "+n+" is even!");
		}else {
			System.out.println("The number "+n+" is odd!");
		}
		
	}

}
