package B.patterns;

/*
----------
Pattern O
ABCDE
ABCD
ABC
AB
A
----------

*/

public class PatternO {
	
	public static void getPettern(int n) {

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=(n-i)+1;j++) {
				System.out.print((char)(j+64)+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
