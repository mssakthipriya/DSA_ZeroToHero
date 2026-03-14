package B.patterns;

/*
----------
Pattern U
* * * * *
*       *
*       *
*       *
* * * * *

----------

*/

public class PatternU {
	
	public static void getPettern(int n) {
		
		for(int i=1;i<=n;i++) {
			
			if(i==1 || i==n) {
			for(int j=0;j<n;j++) {
				System.out.print("* ");
			}
			}else {
				System.out.print("* ");
				for(int j=1;j<n-1;j++) {
					System.out.print("  ");
				}
				System.out.print("* ");
			}

			System.out.println();
		}
		

	}
	public static void main(String[] args) {
		getPettern(5);
	}
}
