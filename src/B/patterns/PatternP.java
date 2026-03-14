package B.patterns;

/*
----------
Pattern P
A
BB
CCC
DDDD
EEEEE
----------

*/

public class PatternP {
	
	public static void getPettern(int n) {
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print((char)(i+64)+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
