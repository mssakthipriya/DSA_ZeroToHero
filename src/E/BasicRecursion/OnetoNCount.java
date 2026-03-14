package E.BasicRecursion;

public class OnetoNCount {
	
	public static void numberCount(int num) {
		if(num==0)
			return;

		numberCount(num-1);
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		numberCount(5);
	}

}
