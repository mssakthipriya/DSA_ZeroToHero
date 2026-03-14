package B.patterns;

/*
----------
Pattern R
E
DE
CDE
BCDE
ABCDE
----------

*/

public class PatternR {
	
	public static void getPettern(int n) {

		for(int i=1;i<=n;i++) {
			for(int j=i-1;j>=0;j--) {
				System.out.print((char)((n-j)+64)+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
