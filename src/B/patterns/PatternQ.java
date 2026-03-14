package B.patterns;

/*
----------
Pattern Q
   A
  ABA
 ABCBA
ABCDCBA
----------

*/

public class PatternQ {
	
	public static void getPettern(int n) {
		int count=1;
		for(int i=1;i<=n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print((char)(j+64)+" ");
			}
			for(int j=i-1;j>=1;j--) {
				System.out.print((char)(j+64)+" ");
			}
			
			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(4);
	}
}
