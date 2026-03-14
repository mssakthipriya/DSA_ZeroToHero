package M.BitManipulation;

public class BitwiseOperators {

	public static void main(String[] args) {
		int a = 5;
		int b = 9;
		int c = -5;
		
		System.out.println("OR:" +a+"|"+b+"="+(a|b));
		System.out.println("AND:" +a+"&"+b+"="+(a&b));
		System.out.println("XOR:" +a+"^"+b+"="+(a^b));
		System.out.println("Left Shift:"+a+"<<"+2+"="+(a<<2));
		System.out.println("Right Shift:"+a+">>"+2+"="+(a>>2));
		System.out.println("Right Shift:"+c+">>"+2+"="+(c>>1));
		System.out.println("Unsigned Right Shift:"+a+">>>"+1+"="+(a>>>1));
		System.out.println("Unsigned Right Shift:"+c+">>>"+1+"="+(c>>>1));
	}
}
