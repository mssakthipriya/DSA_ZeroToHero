package B.patterns;

/*
----------
Pattern J
*                 *
* *             * *
* * *         * * *
* * * *     * * * *
* * * * * * * * * *
* * * *     * * * *
* * *         * * * 
* *             * *
*                 *
----------

*/

public class PatternT {
	
	public static void getPettern(int n) {
		
		for(int i=1;i<n;i++) {
			
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			
			for(int j=1;j<(2*(n-i)+1);j++) {
				System.out.print("  ");
			}
			
			for(int j=i;j>=1;j--) {
				System.out.print("* ");
			}

			System.out.println();
		}
		
		for(int i=1;i<=n;i++) {
		
			for(int j=n;j>=i;j--) {
				System.out.print("* ");
			}
			for(int k=2;k<2*i;k++) {
				System.out.print("  ");
			}		
			for(int j=0;j<(n-i)+1;j++) {
				System.out.print("* ");
			}
			
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
