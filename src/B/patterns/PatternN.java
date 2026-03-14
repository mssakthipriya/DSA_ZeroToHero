package B.patterns;

/*
----------
Pattern N
A
AB
ABC
ABCD
ABCDE
----------

*/

public class PatternN {
	
	public static void getPettern(int n) {
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print((char)(j+64)+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
